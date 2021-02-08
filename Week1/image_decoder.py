from PIL import Image
import binascii

img = Image.open('7fe3c3f6-Stego.png')
width, height = img.size

extracted_bin = [str(img.getpixel((y, x))[2]&1) for x in range(0, height) for y in range(0, width)]
extracted_bytes = ["".join(extracted_bin[i:i+8][::-1]) for i in range(0, len(extracted_bin), 8)]

result = ''
for byte in extracted_bytes:
    if byte != '00000000':
        result += chr(int(byte, 2))
    else:
        break

print ("Secret Message: ", result)