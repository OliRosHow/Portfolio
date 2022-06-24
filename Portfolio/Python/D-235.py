# Name: Olivia Howard       Date Assigned: 3-17-2021
#
# Course: CSCI 2000 60356   Date Due: 3-24-2021
#
# Instructor: Ms. Greer
#
# File name: D-235.py
#
# Program Description: this program collets numbers from user input and outputs the how many of those numbers are divisable by either 2, 3, or 5


num = "" # accumulator to build integers from user input
divisibleBy2 = 0 # divisability counters
divisibleBy3 = 0
divisibleBy5 = 0

userInts = input("Enter numbers seperated by a space: " )# user inputs thier integers seperated by a space

for x in (userInts+" "):

    if x.isdigit() or x == ".": # check if the input is an integer
        num += x # accumulate the value num to generate the numbers between the spaces of the user input

    
    elif x.isspace() and num != "": # when a space is found the accumulated value num is tested for its divisibility only if it isn't a blank value
        
        if not(isinstance(eval(num), float)) and int(num)%2 == 0: #test for divisability by 2 dont check floats
            divisibleBy2 += 1

        if not(isinstance(eval(num), float)) and int(num)%3 == 0: #test for divisability by 3 dont check floats
            divisibleBy3 += 1

        if not(isinstance(eval(num), float)) and int(num)%5 == 0: #test for divisability by 5 dont check floats
            divisibleBy5 +=1
        num = "" # reset the accumulator num

print("\n{0:s}\n{1:^17s}|{2:^17s}|{3:^17s}\n{0:s}\n{4:^17d}|{5:^17d}|{6:^17d}\n{0:s}".format(# the final output
    "="*52, "Divisable by 2", "Divisible by 3", "Divisible by 5", divisibleBy2, divisibleBy3, divisibleBy5))
 #index 0            1               2                   3              4            5              6     
