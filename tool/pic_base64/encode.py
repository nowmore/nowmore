#!/usr/bin/env python

import base64
from sys import argv


def Usage(name):
    print("Usage python %s path_to_picture" % name)
    exit()
    
if __name__ == "__main__":
    if len(argv) < 2:
        Usage(argv[0])

    with open(argv[1], 'rb') as pic:
        data = base64.b64encode(pic.read())
        print('data:image/jpeg;base,%s' % data)