
class Rank:
    def __init__(self, word, number):
        self.word = word
        self.number = number




def main():
    # TODO: Add your code here
    mylist = []
    # Open a file for reading
    with open('part-r-00000', 'r') as file:
        # Read the file line by line
        for line in file:
            # Split the line into words
            words = line.split()
            # Check if there are at least two words in the line
            if len(words) >= 2:
                first_word = words[0]
                # Access the second word (index 1)
                second_word = words[1]
                # Process the second word (e.g., print it)
                # print( first_word + " > " + second_word)
                
                if int(second_word) >= 5000:
                    
                    temp = Rank(first_word, int(second_word))
                    mylist.append(temp)
                    
                    with open('freq-results.txt', 'a') as file:
                        
                        # Write a single line to the file
                        file.write(first_word + " " + second_word + '\n')
                        
    mylist.sort(key=lambda x: x.number, reverse=True)
    with open('freq-results-sorted.txt', 'w') as file:
        for i in mylist:
            file.write(i.word + " " + str(i.number) + '\n')

    pass

if __name__ == "__main__":
    main()