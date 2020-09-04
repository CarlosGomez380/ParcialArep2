# AREP - LAB 2

A program to calculate the mean and standard deviation of a set of n real numbers. The program reads the n real numbers from a file.

## Getting Started

### Pre-requisites

You need to have installed on your PC:

- JDK 
- Maven 
- Git

### Installing

Open a command prompt on the folder that you are going to save this project and copy:

```
git clone https://github.com/CarlosGomez380/arep-lab1.git
```

![](https://github.com/CarlosGomez380/arep-lab1/blob/master/img/clone.PNG)

Once finish this process, open the project on the terminal with 

```
cd arep-lab1
```

And copy:

```
mvn package
```

![](https://github.com/CarlosGomez380/arep-lab1/blob/master/img/package.PNG)

## Running the tests

To run test, open the folder of this project and a command prompt on this location and copy:

```
mvn test
```

![](https://github.com/CarlosGomez380/arep-lab1/blob/master/img/test.PNG)

![](https://github.com/CarlosGomez380/arep-lab1/blob/master/img/runnigTest.PNG)

## Deployment

To deploy this project open the folder of this project and a command prompt on this location and copy:

```
java -cp target/classes;target/dependency/* edu.escuelaing.arep.lab1.SparkWebApp
```

![](https://github.com/CarlosGomez380/arep-lab2.1/blob/master/img/deploy2.PNG)

Open your browser and type:

```
http://localhost:4567/inputdata
```

![](https://github.com/CarlosGomez380/arep-lab2.1/blob/master/img/deploy3.PNG)


## Documentation JavaDoc

To see the javadoc generated copy:

```
mvn javadoc:javadoc
```

This document will be located in /target/site

## Heroku deployment

[![Deployed to Heroku](https://www.herokucdn.com/deploy/button.png)](https://serene-reaches-79126.herokuapp.com/inputdata)

## Built With

- [Maven](https://maven.apache.org/) - Dependency Management

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details
