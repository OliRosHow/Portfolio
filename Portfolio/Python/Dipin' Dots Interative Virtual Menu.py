# Name: Olivia Howard    Date Assigned: 3-31-2021 
#
# Course: 2000-60356     Date Due: 4-9-2021 
#
# File name: Dipin' Dots Interactive Virtual Menu.py
#
# Program Description: This program allows the user to pick an unlimited amout of scoops from the Dippin' Dots menu
#                      to add to thier order and once the user is satisfied with thier selections, it displays the
#                      users recipt with all of thier flavor selections along with the subtotal, tax and total






def main():

    displayStoreInfo() # displays store title and info about ordering

    flavors = "" # accumulator value to keep up with all the flavored scoops
    flavor = 0 # initializing flavor value to use in deturmineFlavor() function
    scoops = 0 # to keep count of the number of scoops

    while flavor != 5: # allows the user to enter as many scoops as they want

        flavor = getFlavorMenuOption()# gathers user input and sets equal to flavor

        if flavor != 5: # if flavor isn't the end value it adds it to the accumulator flavors

            flavors += deturmineFlavor(flavor)# takes the int value flavor and converts it to the actual flavor and adds it to flavors
            scoops += 1 # adds a scoop

    subtotal = .5 * scoops #subtotal value to five to displayReciept() function
    
    displayReceipt(subtotal, flavors)# displays the full reciept and terminates the program
            
        
 
    
    
def displayStoreInfo(): # this function displays the store title and information

    print(("{0:^41s}\n{1:^41s}\n{0:^41s}\n\nWelcome!\n\n"+ # title and welcome
           "Create your own Dippin' Dots combo here!\n\n"+ 
           "Each scoop is $0.50. Choose as many\n"+ # gives price per scoop
           "scoops of each flavor as you want.\n\n"+
           "."*41+"\n").format( 
               ":"*19, ":Dippin':Dots:Shop:"))



def displayMenu(): # this function displays the menu options

    print("Flavor Options:\n"+":.::.:..:.:.:..\n"+# title and seperator
          "1. Vanilla\n2. Chocolate\n3. Strawberry\n4. Cotton Candy\n5. Checkout\n")#choices



def getFlavorMenuOption(): # gets the flavor choice from the user

    displayMenu()
    
    menuOption = (input("Enter Choice (1-5): "))

    while menuOption < "1" or menuOption > "5": #input validation
        
        menuOption = input("Error! Enter a number 1-5 that is next to your menu option: ")

    print("\n"+"."*41+"\n")

    return int(menuOption)# returns the integer associated to that menu option

    
        
def deturmineFlavor(menuOption): # takes an integer 1-5 and retruns the menu item corresponding to that integer

    if menuOption == 1:
        return "Vanilla!"

    elif menuOption == 2:
        return "Chocolate!"

    elif menuOption == 3:
        return "Strawberry!"

    elif menuOption == 4:
        return "Cotton Candy!"

    else:
        return 5



def displayReceipt(subtotal, flavors): # displays the recipt using subtotal and flavors
    print(("CHECKOUT\n"+
          ":.::..:..\n\n"+
          "{0:<s}\n{1:^19s}\n{0:<s}\n"+
          "Scoops").format("."*19, "Receipt"))# header

    flavor = ""
    
    for ch in flavors: # reads the varible flavors to get individual flavors to print

        if ch != "!":
            flavor += ch
        else:
            print(" * "+flavor)
            flavor = ""

    tax = subtotal * 0.11 # calculates the tax and total
    total = subtotal + tax

    print(("."*19+"\n"+
           "Subtotal: ${0:<.2f}\n"+
           "Tax:      ${1:<.2f}\n"+
           "Total:    ${2:<.2f}\n"+
           "."*19).format(subtotal, tax, total))# displays subtotal, tax and total
    

main()#main function call
