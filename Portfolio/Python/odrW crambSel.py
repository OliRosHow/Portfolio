# Name: Olivia Howard (David)           Date Assigned: March 3, 2021 
#
# Course: 2000-60356                    Date Due: March 10, 2021
#
# Instructor: Ms. Greer
#
# File name: odrW crambSel.py
#
# Program Description: This program is a word unscrambling game with 3 set words to unscrable. For each correct
#                      unscrambling the user gains a point. After five attempts with incorrect unscramblings, the
#                      user gains no points for that word. After the user has used all thier attempts or unsrambled
#                      all of the words, the users final score is displayed and the program ends

# the correct answers for the respective word
word1 = "knowlege" 
word2 = "summary"
word3 = "frequency"
numWord = 0 # will use this variable for keeping up with what word we are on
goal = "Unscramble the following words." # this is what the users goal is
rule = "You have 5 tries to unscramble each word"# this is to let the user know that they only get 5 tries
score = 0 # for score keeping

print("{4:s}\n{0:^80s}\n{1:s}\n\n-{2:s}\n\n-{3:s}".format("odrW crambSel", "'"*80, goal, rule, ","*80))#title screen with goal displayed and rule displayed

while numWord < 3: # start of game

    numWord += 1
    print(("\n{0:^80s}\n{4:s}{"+str(numWord)+":^10s}{4:s}\n{5:^80s}").format(
        ","*10, "Word 1", "Word 2", "Word 3", ":"*35, "'"*10 )) # displays what word we are on


    if numWord == 1: # word one "knowlege"
        word = input("Unscramble oewlngked: ")

        if word.lower() == word1: # first attempt
            score +=1
        else:
            word = input("Unscramble oewlngked: ")

            if word.lower() == word1: # second attempt
                score +=1
            else:
                word = input("Unscramble oewlngked: ")

                if word.lower() == word1: # third attempt
                    score +=1
                else:
                    word = input("Unscramble oewlngked: ")

                    if word.lower() == word1: # fourth attempt
                        score +=1
                    else:
                        word = input("Unscramble oewlngked: ")

                        if word.lower() == word1: # fifth attempt
                            score +=1
                        else:
                            score = score # at this point the score just is what it is "0"


    elif numWord == 2: # word two "summary"
        word = input("Unscramble mmuayrs: ")

        if word.lower() == word2: # first attempt
            score +=1
        else:
            word = input("Unscramble mmuayrs: ")

            if word.lower() == word2: # second attempt
                score +=1
            else:
                word = input("Unscramble mmuayrs: ")

                if word.lower() == word2: # third attempt
                    score +=1
                else:
                    word = input("Unscramble mmuayrs: ")

                    if word.lower() == word2: # fourth attempt
                        score +=1
                    else:
                        word = input("Unscramble mmuayrs: ")

                        if word.lower() == word2: # fifth attempt
                            score +=1
                        else:
                            score = score # at this point the score just is what it is "0" or "1"


    else: # word three "frequency"
        word = input("Unscramble fyecnreuq: ")

        if word.lower() == word3: # first attempt
            score +=1
        else:
            word = input("Unscramble fyecnreuq: ")

            if word.lower() == word3: # second attempt
                score +=1
            else:
                word = input("Unscramble fyecnreuq: ")

                if word.lower() == word3: # third attempt
                    score +=1
                else:
                    word = input("Unscramble fyecnreuq: ")

                    if word.lower() == word3: # fourth attempt
                        score +=1
                    else:
                        word = input("Unscramble fyecnreuq: ")

                        if word.lower() == word3: # fifth attempt
                            score +=1
                        else:
                            score = score # at this point the score just is what it is "0", "1", or "2"  

  
print ("\n{2:s}\n{0:^80s}\n{1:s}".format(
    ("You unscrambled "+str(score)+" word(s)!"), "'"*80, ","*80)) # displays final score
