# photonvision-tests

In this test a code was written for a camera to get results and from those results get the best target.
Then obtain and display the target's pitch, yaw and area in a shuffleboard.

We had to look in the results at every frame for targets to make sure we would not get a null pointer pointer exception,
and add a conditional to let the program know that if the target exists, we can get its yaw, pitch and area values.