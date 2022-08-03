# this program implements matplotlib and numpy to plot a scatter plot based on the diabetes dataset imported from
# sklearn. We will use linear regression to find the line of best fit for this graph
import matplotlib.pyplot as plt
import numpy as np
from sklearn.datasets import load_diabetes


def bestfit(x, y):
    """ takes elements of the x and y lists as coordinates and finds the coefficients for the
        gradient equation.

    :param x: x coordinates list
    :param y: y coordinates list
    :return: coefficients
    """
    x = np.array(x)
    y = np.array(y)

    # removes an extra dimension from the x array
    x = x.squeeze()

    # finds the coefficients for the gradient equation
    b1 = (((np.mean(x) * np.mean(y)) - np.mean(x * y)) / ((np.mean(x) * np.mean(x)) - np.mean(x * x)))
    b0 = np.mean(y) - b1 * np.mean(x)

    print("Coefficient b1 is: ", b1)
    print("Coefficient b0 is: ", b0)

    # returns the coefficients
    return b1, b0


def mse(actual, pred):
    """
    :param actual: the actual y values
    :param pred: the predicted y values
    :return: mean square error
    """
    actual, pred = np.array(actual), np.array(pred)
    return np.square(np.subtract(actual, pred)).mean()


# linear model is imported
d = load_diabetes()

# selects the features we wish to use in our graph
d_X = d.data[:, np.newaxis, 2]

# splits last 20 samples to be used for training and testing data
dx_train = d_X[:-20]
dy_train = d.target[:-20]
dx_test = d_X[-20:]
dy_test = d.target[-20:]

# finds the coefficients of the best fit line
b1, b0 = bestfit(dx_train, dy_train)

# finds the y predicted values
y_pred = (b1 * dx_train) + b0

# mean square error
print(mse(dy_test, y_pred))

# implements a scatter plot containing all the necessary data
plt.scatter(dx_train, dy_train, c='r')
plt.scatter(dx_test, dy_test, c='g')
plt.plot(dx_train, y_pred, c='b')
plt.legend(("train", "test"))

# displays the graph
plt.show()
