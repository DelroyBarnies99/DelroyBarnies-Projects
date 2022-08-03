# this program reads data on vaccinations and deaths in south africa 2022 during the month of june and implements
# polynomial regression modeling to plot a scatter plot on the data with the correct polynomial and linear regression
# lines.

import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import PolynomialFeatures

# reads the csv
path = "dataCovid19.csv"
data = pd.read_csv(path)

# saves the vaccination and deaths columns data to x and y as pandas series
x, y = data["Vaccinations"], data["Deaths"]

# splits the x and y series into training and testing data
X_train, x_test, y_train, y_test = train_test_split(x, y)
x_train_df, x_test_df = pd.DataFrame(X_train), pd.DataFrame(x_test)

# converts all training and testing series into 2d nested lists(dataframes)
X_train, y_train = [[x] for x in X_train], [[x] for x in y_train]
x_test, y_test = [[x] for x in x_test], [[x] for x in y_test]

# trains the Linear Regression model and plots a prediction
lin_model = LinearRegression()
lin_model.fit(X_train, y_train)
x_axis = np.arange(800000, 7000000, 0.5)
yy = lin_model.predict(x_axis.reshape(x_axis.shape[0], 1))
plt.plot(x_axis, yy, c="g")

# sets the degree for the polynomial regression model
polyFeat = PolynomialFeatures(degree=2)

# This preprocessor transforms an input dataframe into a new dataframe of a given degree
x_train_quad = polyFeat.fit_transform(np.array(x_train_df))
x_test_quad = polyFeat.transform(np.array(x_test_df))

# trains the polynomial regression model
model = LinearRegression()
model.fit(x_train_quad, y_train)
response = polyFeat.transform(x_axis.reshape(x_axis.shape[0], 1))

# plots the graph
plt.scatter(x, y)
plt.plot(x_axis, model.predict(response), c='r', linestyle='--')
plt.title('Covid19 deaths in South Africa regressed on diameter')
plt.xlabel('Vaccinations per province (1:1000000)')
plt.ylabel('Deaths per province')
plt.show()
