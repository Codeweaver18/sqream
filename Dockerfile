FROM python:3.8-alpine
COPY ./requirements.txt /app/requirements.txt
WORKDIR /app
RUN pip3 install -r requirements.txt
COPY . /app
RUN chmod u+x docker.sh
EXPOSE 5000
ENTRYPOINT [ "python3" ]
CMD ["app.py" ]