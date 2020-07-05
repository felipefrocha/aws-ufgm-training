FROM node:12-slim

RUN mkdir /app
WORKDIR /app

COPY node_modules ./node_modules
COPY package.json ./package.json


RUN npm i

COPY . .

ENTRYPOINT npm start