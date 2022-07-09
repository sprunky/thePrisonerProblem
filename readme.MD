Problem
The 100 prisoners problem has different renditions in the literature. The following version is by Philippe Flajolet and Robert Sedgewick:[1]

The director of a prison offers 100 death row prisoners, who are numbered from 1 to 100, a last chance. A room contains a cupboard with 100 drawers. The director randomly puts one prisoner's number in each closed drawer. The prisoners enter the room, one after another. Each prisoner may open and look into 50 drawers in any order. The drawers are closed again afterwards. If, during this search, every prisoner finds his number in one of the drawers, all prisoners are pardoned. If just one prisoner does not find his number, all prisoners die. Before the first prisoner enters the room, the prisoners may discuss strategy — but may not communicate once the first prisoner enters to look in the drawers. What is the prisoners' best strategy?
If every prisoner selects 50 drawers at random, the probability that a single prisoner finds his number is 50%. Therefore, the probability that all prisoners find their numbers is the product of the single probabilities, which is (
1
/
2
)100 ≈ 0.0000000000000000000000000000008, a vanishingly small number. The situation appears hopeless.

Solution
Strategy
Surprisingly, there is a strategy that provides a survival probability of more than 30%. The key to success is that the prisoners do not have to decide beforehand which drawers to open. Each prisoner can use the information gained from the contents of every drawer he already opened to decide which one to open next. Another important observation is that this way the success of one prisoner is not independent of the success of the other prisoners, because they all depend on the way the numbers are distributed.[2]

To describe the strategy, not only the prisoners, but also the drawers, are numbered from 1 to 100; for example, row by row starting with the top left drawer. The strategy is now as follows:[3]

Each prisoner first opens the drawer labeled with his own number.
If this drawer contains his number, he is done and was successful.
Otherwise, the drawer contains the number of another prisoner, and he next opens the drawer labeled with this number.
The prisoner repeats steps 2 and 3 until he finds his own number or has opened fifty drawers.
By starting with his own number, the prisoner guarantees he is on a sequence of drawers containing his number. The only question is whether this sequence is longer than fifty drawers.

Examples
The reason this is a promising strategy is illustrated with the following example using 8 prisoners and drawers, whereby each prisoner may open 4 drawers. The prison director has distributed the prisoners' numbers into the drawers in the following fashion:

number of drawer	 1  	  2  	  3  	  4  	  5  	  6  	  7  	  8  
number of prisoner	7	4	6	8	1	3	5	2
The prisoners now act as follows:

Prisoner 1 first opens drawer 1 and finds number 7. Then he opens drawer 7 and finds number 5. Then he opens drawer 5, where he finds his own number and is successful.
Prisoner 2 opens drawers 2, 4, and 8 in this order. In the last drawer he finds his own number 2.
Prisoner 3 opens drawers 3 and 6, where he finds his own number.
Prisoner 4 opens drawers 4, 8, and 2, where he finds his own number. Note that this is the same cycle encountered by prisoner 2, but he isn't aware of it.
Prisoners 5 to 8 will also each find their numbers in a similar fashion.
In this case, all prisoners find their numbers. This is, however, not always the case. For example, the small change to the numbers of swapping drawers 5 and 8 would cause prisoner 1 to fail after opening 1, 7, 5, and 2 (and not finding his own number):

number of drawer	  1  	  2  	  3  	  4  	  5  	  6  	  7  	  8  
number of prisoner	7	4	6	8	2	3	5	1
And in the following arrangement, prisoner 1 opens drawers 1, 3, 7, and 4, at which point he has to stop unsuccessfully:

number of drawer	  1  	  2  	  3  	  4  	  5  	  6  	  7  	  8  
number of prisoner	3	1	7	5	8	6	4	2
Indeed, all prisoners except 6 (who succeeds directly) fail.

