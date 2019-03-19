/* ************************
// Author: Md Mabrur Husan Dihyat */

import java.util.*;
class MIniProject
{
	

	public static void main (String[] param)
	{
		project();
		System.exit(0);
	}// End Main
	
	public static void project()
	{ 	
		final int size = 5;//size of array//
		questionAnswers [] array = new questionAnswers[size];// array of records. //
		for(int i = 0; i< array.length; i++)
		{
		  questionAnswers a = new questionAnswers();
		  array[i] = a;
		  array[i] = setAnswersandQuestions(array[i] , i);
		}


	
		System.out.println("Welcome to the MHD Sports Quiz");


		for(int h = 0; h < array.length; h++)
		{
			System.out.println(""+getQuestion(array[h]));
			answer(array[h]);
			//System.out.println();
			scoreStats(array);
		}
	}	//this method initializes the array size and makes an array of records//

	public static void scoreStats(questionAnswers[] array)
	{
		for(int i =0; i<array.length-1 ; i++)
		{
			for(int j=0 ; j<array.length-1; j++)
			{
				if(getScore(array[j]) < getScore(array[j+1]))
				{
					swop(array,j,j+1);
				}
			}//checks one part of the array
		}//checks every single array bits

		for(int show = 0; show<array.length;show++)
		{
			ShowStats(array[show]);
		}
	}	//sorting//

	public static void ShowStats(questionAnswers p)
	{
		System.out.println("Question Number " + getQuestionNumber(p) + "   score " + getScore(p)); // prints the number of the question and the score//
	}

	public static void swop(questionAnswers [] array, int first, int second )
	{
		questionAnswers helper;
		helper = array[first];
		array[first] = array[second];
		array[second] = helper;
	}//swaps the array//




	public static void answer(questionAnswers f)
	{	
		int tries = 0;
		
		while(tries < 3) 
		{
			// get guess
			String guess = getInput();
			
			
			if (guess.equalsIgnoreCase(getAnswer(f)))
			{
				System.out.println("Your answer is correct!") ;
				f.score = 100;
				
			}

			else
			{
				int Marks = diceroll();
				if(Marks == 1)
				{
					f.score = f.score + 3;
				}
				else if (Marks == 2)
				{
					f.score = f.score + 6;
				}
				else if (Marks == 0)
				{
					f.score = f.score + 1;
				}
				else
				{
					System.out.println("Something Wrong");
				}
				System.out.println("Unfortunately your answer was incorrect. You got additional score " + f.score + "\n Please try again");
			
				
			}//assigns the random mark if the answer is wrong
				if(f.score >= 100)
				{
					tries = tries + 3; //the number of tries//
				}
				else
				{
					tries++;
				}
			 // increment by 1
		} //while loop ends//

		
		
	}

	/*public static void printMessage(boolean isCorrect, int marks) 
	{
		if(isCorrect)
			System.out.println("Congratulations! Your answer is correct. Your marks are " + marks);
		else 
			System.out.println("Sorry but your answer is wrong. Your marks are 0");
	}// This */ 

	public static questionAnswers setAnswersandQuestions(questionAnswers b, int i)
	{
		if (i == 0)
		{
			b.question = "Who won the last football World Cup?\nThe options are: 1.Brazil 2.Argentina 3.Spain 4.Germany";
			b.answer = "Germany";
		}
		else if (i == 1)
		{
			b.question = "Who won the Golden Boot?\nThe options are: 1.Cristiano Ronaldo 2.James Rodriguez 3.Lionel Messi 4.Tony Kroos ";
			b.answer = "James Rodriguez";
		}
		else if (i == 2)
		{
			b.question = "Which team conceded the most goals?\nThe options are: 1.Netherlands 2.Spain 3.Nigeria 4.Brazil";
			b.answer = "Brazil";
		}
		else if (i == 3)
		{
			b.question = "How many teams European teams made into the last 16 stage?\nThe options are: 1.six 2.five 3.seven 4.four";
			b.answer = "six";
		}
		else if (i == 4)
		{
			b.question = "Where was the first game played?\nThe options are: 1.Rio De Janerio 2.Sao Paolo 3.Medellin 4.London";
			b.answer = "Sao Paolo";
		}

		b.questionNumber = i=i+1;
		return b;
	}// This method stores the question and answers//


	public static String getInput()
	{

		String UserAnswer;
		Scanner scanner = new Scanner(System.in);
		UserAnswer = scanner.nextLine();

		return UserAnswer;	

	} // This method takes the user input//


	public static int marks() // assigns the random question order//
	{
		 int r = (int)(Math.random()*2);
		 
		 return r;
	}
	

	public static int diceroll()
	{
		int dice = 0;
		Random diceroll = new Random();
		dice = diceroll.nextInt(3);

		return dice;
	}


	public static String getAnswer(questionAnswers q)
	{
		return q.answer;
	}//getter method//


	public static String getQuestion(questionAnswers q)
	{
		return q.question;
	}//getter method//


	public static int getScore(questionAnswers k)
	{
		return k.score;
	}//getter method//
	
	public static int getQuestionNumber(questionAnswers s)
	{
		return s.questionNumber;
	}
	


}

class questionAnswers //records//
{
	String question;
	String answer;
	int questionNumber;
	int score;

}


	