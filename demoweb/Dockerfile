# pull official base image
FROM node:12-alpine

# set working directory
WORKDIR /app

# Add args
# ARG HOST=localhost
# ARG PORT=8080

# add hosts info
# ENV HOST ${HOST}
# ENV PORT ${PORT}
# add `/app/node_modules/.bin` to $PATH
ENV PATH /app/node_modules/.bin:$PATH

# install app dependencies
COPY package.json ./
COPY package-lock.json ./
RUN CI=true npm install --silent
RUN CI=true npm install react-scripts@3.4.0 -g --silent

# add app
COPY . ./

EXPOSE 3000

# start app
CMD CI=true npm start
