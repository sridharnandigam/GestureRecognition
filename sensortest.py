from sensordroid import Client

import time

def devicesDiscoveredEventHandler(devices):
    print(devices)
    if len(devices) > 0:
        client = Client(devices[0])
        client.connectionUpdated = connectionUpdatedEventHandler
        client.sensorsReceived = sensorsReceivedEventHandler
        client.imageReceived = cameraReceivedEventHandler
        client.sensorsSampleRate = 50
        client.cameraResolution = 13

        client.connect()

def connectionUpdatedEventHandler(sender, msg):
    if sender is not None:
        if sender.connected:
            print("Connected")
        else:
            print("Disonnected")


def sensorsReceivedEventHandler(sender, dataCurrent):
    result = dataCurrent.Acceleration.Values.AsString
    x = result.split(",")
    currenttime = time.time() * (10.0)**9 - start_time
    first = x[0].strip()
    second = x[1].strip()
    third = x[2].strip()
    something = first + "," + second + "," + third + ",0" + "\n"
    with open('user30.txt', 'a+') as f:
        f.write(something)

def cameraReceivedEventHandler(sender, image):
    # Process image data bytes
    pass

start_time = time.time() * (10.0)**9;
Client.devicesDiscovered = devicesDiscoveredEventHandler
Client.startDiscovery()
key = input("Press ENTER to exit\n")
Client.closeAll()
