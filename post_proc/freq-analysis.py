def main():
    # TODO: Add your code here
    # Open a file for reading
    with open('output_wordcount', 'r') as file:
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
                    with open('freq-results.txt', 'a') as file:
                        # Write a single line to the file
                        file.write(first_word + " > " + second_word + '\n')

    pass

if __name__ == "__main__":
    main()