# SpaceShooter

### Introduction
This is first android project. It is the game like a normal space invaders game :space_invader:. You can run desktop and android version. Written fully on Java :coffee: with LibGDX framework.

### Bucket list
- Graphics 
  - [ ] Add new model of player ship :heavy_exclamation_mark: 
  - [ ] Add new enemies model :heavy_exclamation_mark:
  - [ ] Add new background picture :heavy_exclamation_mark:
  - [ ] Add new bullet images
  - [ ] Add new button images (not sure)

1. important: :heavy_exclamation_mark:
2. not really: 

### Architecture 	:building_construction:
#### Basics
To start with, I want to speak about position system. 
Here, we have 3 base **coordinate systems**:
  1. Pixels
  2. WorldBounds
  3. OpenGl default bounds
  
In order to use position system comfortably, I have created a ```Rect``` class and ```MatrixUtils``` class, where I can switch between coordinate systems. ```Rect``` class is a class, where I can use methods such as ```setBottom```, ```setWidth``` and so on.
All this utils, you can find at math package :file_folder:

#### Sprites
In order, to draw objects, I have created a class, called ```Sprite```. Here you can call the ***constructor*** with ```TextureRegion``` as a parameter, or even you can call another ***constructor*** for a texture which contains several images. All you need is to give rows and columns of your texture and it will split your image into parts and store it. It also has methods which will allow you to move your image on the screen, ```touchUp``` and ```touchDown``` buttons for some ```ActionPerfomed``` methods.
