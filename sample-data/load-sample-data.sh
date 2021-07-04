#!/bin/bash


mongoimport --db greetings --collection greetings --drop --jsonArray --jsonArray --file ./sample-data.json

# --collection greetings --drop --jsonArray --jsonArray --file ./sample-data.json