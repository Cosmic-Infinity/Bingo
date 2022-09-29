# Bingo
A number bingo management system which was designed for a mini game planned for Teacher's Day 2022. And although the game event was cancelled, this 7hr project was already complete by the time. So here it is.

I currently have have no plans to use it, but the system was usable enough for a release.



Might add a detailed documentation later, but now, here are the basics.

1. Every class has one public function, which performs one task for the game.
2. `Generate_Ticket` generaates a .csv template _(Tickets.csv)_, which can be imported into excel and printed. These can serve as custom tickets for the game. The parameters are self-explanatory.
3. `Random_Gen` generates a random list of numbers in a range and saves them to _GeneratedList.txt_. Once generated, it is used throughout the game. Make sure it is run first with the parameters of choice.
4. `Play` is the main game. The numbers from _GeneratedList.txt_ is shown one by one for it to be announced.
5. `Check_Result` is used once someone wins. Input how far down the random list you are, then enter the numbers of the winning card to check for a mismatch.
6. `Save_Location` as the name implies, saves the location of the output files. By default it saves to _Desktop_ 
