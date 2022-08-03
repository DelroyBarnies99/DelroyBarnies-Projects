# program reads data from the csv file and uses the k means algorithm to plot a scatter plot on the data

import numpy as np
import numpy as py
import statistics
import csv
from sklearn.cluster import KMeans
import matplotlib.pyplot as plt
from sklearn.metrics import pairwise_distances_argmin


def read_csv():
    """ :return: dataset, x_label, y_label, x list ,y list and countries from the csv file
    """
    with open('dataBoth.csv', 'r') as csvfile:

        # reads the contents of the file and sets "," as delimiter.
        contents = csv.reader(csvfile, delimiter=',')

        line = 0
        index = 0
        x_list = []
        y_list = []
        countries = []

        # iterates through each line of the contents
        for row in contents:

            # appends the appropriate data to the x and y lists
            if line >= 1:
                countries.append(row[0])
                x_list.append(row[1])
                y_list.append(row[2])
                index += 1
                line += 1

            # gets the appropriate labels for the x and y
            else:
                x_label = row[1]
                y_label = row[2]
                print(', '.join(row))
                line += 1

        # creates a single 2d array from the x and y lists
        data = py.vstack((x_list, y_list)).T

        # sets the array elements to a float data type
        data = data.astype(float)

        # returns dataset and labels
        return data, x_label, y_label, x_list, y_list, countries


def centroid(data, num_clusters, rseed=2):
    """ determine random centroids

    :param data: dataset
    :param num_clusters: number of clusters you want to implement
    :return: dataset, y_kmeans
    """
    # assign labels based on closest center
    kmeans = KMeans(n_clusters=num_clusters)
    kmeans.fit(data)
    y_kmeans = kmeans.predict(data)

    # randomly choose clusters
    rng = py.random.RandomState(rseed)
    i = rng.permutation(data.shape[0])[:num_clusters]
    centroids = data[i]

    return centroids, y_kmeans


def kmeans(data, centroid_num):
    """ get clusters and labels from the dataset

    :param data: dataset
    :param centroid_num: int number of centroids
    :return: 2d nested list of clusters, 2d nested list of labels
    """
    clusters, y_kmeans = centroid(data, centroid_num)

    while True:
        # assign labels based on closest centroid
        labels = pairwise_distances_argmin(data, clusters)

        # find new centers from means of points
        new_centers = py.array([data[labels == i].mean(0) for i in range(centroid_num)])

        # check for convergence
        if py.all(clusters == new_centers):
            break
        clusters = new_centers

    return clusters, labels


#  -> List[np.ndarray]
# https://stackoverflow.com/questions/70714733/split-an-array-according-to-cluster-labels
def get_clusters(x: np.ndarray, y: np.ndarray):
    """ split an array according to cluster labels

    :param x: dataset
    :param y: labels for each point in the dataset
    :return: 3d nested list where the elements of each list
             are data points belonging to the label at that index.
    """
    s = np.argsort(y)
    nd_list = np.split(x[s], np.unique(y[s], return_index=True)[1][1:])

    # convert numpy arrays in the matrix to nested lists
    nd_list = [x.tolist() for x in nd_list]

    # returns 3d matrix
    return nd_list


def mean(arr):
    """ print mean birth rate and life expectancy for each cluster

    :param arr: 3d nested list of clusters
    """
    birth_rate = [[[]]]
    life_exp = [[[]]]

    # for loop finds the means of birth rates and life exp for each cluster and prints it in an easily readable manner
    for i in range(len(arr)):
        for j in range(len(arr[i])):

            # appends x values from data points
            birth_rate.append(arr[i][j][0])
            # appends y values from the data points
            life_exp.append(arr[i][j][1])

        # pops empty nested list element
        birth_rate.pop(0)
        life_exp.pop(0)

        print(f"\nMean Birth Rate for cluster {i}:")
        print(statistics.mean(birth_rate))
        print(f"Mean Life expectancy for cluster {i}:")
        print(statistics.mean(life_exp))

        # clears both lists so they can be used for the next cluster
        birth_rate.clear()
        life_exp.clear()


# returns dataset, x and y labels
data, x_label, y_label, x_list, y_list, countries = read_csv()

data = data.copy(order='C')

# user inputs the amount of clusters to be represented in the scatter plot
centroid_num = int(input("how many clusters?:"))
a, c = centroid(data, centroid_num)

clusters, labels = kmeans(data, centroid_num)

# counts the number of points belonging to each cluster
cluster_count = np.bincount(labels)

print(f"\nnumber of countries belonging to each cluster:")

for i in range(len(cluster_count)):
    print(f"{i} :{cluster_count[i]}")

countries = np.array(countries)

# get the indices of the points for each corresponding cluster
mydict = {i: countries[np.where(labels == i)[0]] for i in range(centroid_num)}

# Transform this dictionary into list (if you need a list as result)
dictlist = []
for key, value in mydict.items():
    temp = [key, value]
    dictlist.append(temp)

print("\nlists of countries belonging to each cluster:")

for item in dictlist:
    print(f"\n{item}")

# prints mean birth rate and life expectancy for each cluster
mean(get_clusters(data, labels))

# plotting the graph
plt.xlabel(x_label)
plt.ylabel(y_label)
plt.scatter(data[:, 0], data[:, 1], c, cmap="viridis")
plt.scatter(clusters[:, 0], clusters[:, 1], c="black", s=200, alpha=0.5)

# displays the scatter plot
plt.show()
