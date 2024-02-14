# Project name: HoneyComb Havoc Backend


## Description

A backend application for a full CRUD user profile page, for a (yet) imaginary game called HoneyComb Havoc. It has a Springboot backend that is usable directly to a frontend application (One such specific is already present on https://github.com/Cristoffer85/HCHFrontV2)

This application is hosted in the cloud on AWS Beanstalk. Direct url to the backend application is http://honeycombback-env.eba-7gcu2wx7.us-west-2.elasticbeanstalk.com
The application there also has a fully functional CICD-pipeline on AWS (Beanstalk EC2), and have Github Actions .yml-files as well (both maven and super-linter)

Any entered data visible in the browser URL will be saved and updated to a remote mongoDB database.

# What was your motivation?

I wanted to test how to build a fully functional CRUD application, mainly built in springboot to be hosted completely in the cloud and have a remote storage to a database so i/anyone could access it anywhere.

# What problem does it solve?

It deploys a fully functional CRUD application in the cloud, with a remote mongoDB storage. It can be used as a backend for a frontend application, and is fully functional and ready to use.

# What did you learn?

I learned how to create a fully functional CRUD application in springboot, and how to make sure its a clean install and is able to faulty free be deployed in the cloud against a CICD-pipeline.

Also learned alot on how AWS Beanstalk works (through alot of trial and errors.. But hey, thats actually how you learn, huh?)

# Installation and usage

FOR MOST COMPLETE USAGE/BEST UX:  

Navigate to https://github.com/Cristoffer85/HCHFrontV2 and download that repo to your local machine, follow readme there for installation and usage.  
From there you will be able to use this already hosted application in the cloud, by starting that application locally on your own machine.

----------------

CLOUD/ONLINE: (The application is deployed on AWS Elastic Beanstalk)
* Navigate to http://honeycombback-env.eba-7gcu2wx7.us-west-2.elasticbeanstalk.com/api/userprofiles
* View it in browser there, and from there you can test the different endpoints with Postman or similar.
* The application will save data remotely to a mongoDB database. Connectionstring is defined in application.properties
* The application is running on a free tier, so it might take a few seconds to start up if it has been inactive for a while.
  * For read all function, on URL above use GET
  * For read one function, on URL above use GET and add /id
  * For create function, on URL above use POST and add JSON object in body
  * For update function, on URL above use PUT and add /id and JSON object in body
  * For delete function, on URL above use DELETE and add /id

LOCAL:
- In IDE navigate to src>main>java>org.example and Start Back_Main. It will run on http://localhost:8080/
- You can test the different endpoints with Postman similar to above, just change the URL to http://localhost:8080/api/userprofiles 

The application will save data remotely to a mongoDB database. Connectionstring is defined in application.properties

# Credits
Classmates from school, family, myself, Mighty Duck rubber duck and some chatGPT for debugging.

# License

🏆 MIT License

# Badges

![Static Badge](https://img.shields.io/badge/Java_100%25-8B4000)



# Features
- [x] Full CRUD functionality
- [x] Remote mongoDB storage
- [x] Hosted in the cloud
- [x] CICD-pipeline on AWS (Beanstalk EC2)
- [x] Github Actions .yml-files (maven and super-linter)
- [x] Fully functional frontend application (connected with by a local repo)