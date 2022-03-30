
## The Challenge

  

The challenge is to create a application that idnetifies the popularity of color themes on a website. A poll is sent out to users to vote on their favourite color. The poll data is saved in two txt files. We have to read those files and print out the most voted on color, and a list of users who voted on the color, in order.

  

> Tools: Java, Visual Studio, 2 Litres of Original Coca Cola, Imagination.

  

## My Approach

  

I chose to write the application in java as Im personally more comfortable and experienced in java(And in case you didn't know, java runs on 6 Billion devices world wide lol). My second option would have been Python, would've been sligthly easier, less code to read the flat files and also displaying the most voted on colors on a bar/pie chart would have been visually appealing I think.

  

So the steps I followed are:

  

- Read the users file and save in an appropriate structure.

  

- Read the favourites file and save in an appropriate structure.

  

- Write an algorith to figure out which color has the most votes.

  

- Save the user IDs that voted for that color in a list.

  

- Compare the above list with the saved user data and retrieve the name that the ID belongs to.

  

- Print the results in console and also to a text file.

  

- Text file created and opened automatically then program ends.

  

> You can find this new file in `./data/results.txt`

  

  

## Challenges Faced

  

My one issue was how the poll data was stored ie. plain text not comma seperated. This adds some extra steps in reading the file and can easily throw errors since it lacks structure. Storing the data in JSON format would be much safer and easier to process. But it's all good, the app "works on my machine" :)

  

# Q&A

> What advantages does this language offer for solving this problem?

  *For this challenge and its constraints, with Java I didn't have to import and other library to solve it, what I need is included in the platform. It runs faster which was my concern with the large text files and the iterations I had to do.*

>In what ways does this language make it more difficult to solve this problem?

*Compared to my 2nd option(Python), there's a bit more code written in the Java solution but I wouldn't say it makes it more difficult, I dont mind more code as long as its readable.*  

>Did you do anything to make the solution run faster?

*At this time I do not see a better way to make it faster .*
