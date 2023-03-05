FROM gradle:8.0.2-focal AS build

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle distZip


FROM amazoncorretto:17.0.6 AS jdk-runtime
RUN yum install -y unzip
RUN mkdir /app
COPY --from=build /home/gradle/src/build/ /app/
WORKDIR /app
RUN unzip ./distributions/ChessFactory-1.0.zip && rm ./distributions/ChessFactory-1.0.zip
CMD ["./distributions/ChessFactory-1.0/bin/ChessFactory"]
