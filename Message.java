// Name: Sani Haseeb

package assignment1;

public class Message
{
	public String message;
	public int lengthOfMessage;

	public Message (String m)
	{
		message = m;
		lengthOfMessage = m.length();
		this.makeValid();
	}
	
	public Message (String m, boolean b)
	 {
		message = m;
		lengthOfMessage = m.length();
	 }
	
	/**
	 * makeValid modifies message to remove any character that is not a letter and turn Upper Case into Lower Case
	 */
	public void makeValid()
		{

		String msg = message.replaceAll("\\s", "");
		String msg2 = msg.replaceAll("[^a-zA-Z]","");
			
			message = msg2.toLowerCase();
		  lengthOfMessage = message.length();
			
			
			  
		}
	
	
	/**
	 * prints the string message
	 */
	public void print()
	{
		System.out.println(message);
	}
	
	/**
	 * tests if two Messages are equal
	 */
	public boolean equals(Message m)
	{
		if (message.equals(m.message) && lengthOfMessage == m.lengthOfMessage)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * caesarCipher implements the Caesar cipher : it shifts all letter by the number 'key' given as a parameter.
	 * @param key
	 */
	public void caesarCipher(int key)
	{
		
	String KeyVal [] = 
	{"a","b","c","d", "e", "f", "g", "h", "i", "j", "k", "l","m",
	 "n", "o", "p" ,"q", "r", "s", "t", "u", "v","w", "x", "y", "z"};
         
	
	StringBuilder s1 = new StringBuilder(message);
	key = key%26;
		for(int i = 0; i < s1.length(); i++) 
		{
	        int k = 0;
			String str = s1.substring(i, i+1);
			while (!(str.equals(KeyVal[k]))) 
			{
				k++;	
			}
			
			if (key > 0)
			   {
			s1.setCharAt(i, KeyVal[(k+key)%26].charAt(0));
			   }

				else if (key<0)
				{
					s1.setCharAt(i, KeyVal[(26*-key + k + key)%26].charAt(0));
				}
				
		 }
				message = s1.toString();
	
	}
			

	public void caesarDecipher(int key)
	{
		this.caesarCipher(- key);
	}
	
	/**
	 * caesarAnalysis breaks the Caesar cipher
	 * you will implement the following algorithm :
	 * - compute how often each letter appear in the message
	 * - compute a shift (key) such that the letter that happens the most was originally an 'e'
	 * - decipher the message using the key you have just computed
	 */
	public void caesarAnalysis()
	
	
	{
	String [] character = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
			"l", "m", "n" , "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y","z"};	
	
	int number[] = new int[26];
	
		for(int i = 0; i < message.length(); i++) 
		{
			String check = message.substring(i, i+1);
			for(int k = 0; k < 26 ; k++) 
			{
		
		if(check.contains(character[k]))
				{
			number[k] = number[k]+1;
				}
		
			
		     }

		}
		
		String maximum = null;
		int max = 0;
		for(int count = 0; count < 26; count++) 
		{
			if(number[count] > max) 
			{
				max = number[count];
				maximum = character[count];
	
			}
			
		}
		
		int n = 0;
		int l = 0;
		int t = 0;
	
	while(!(character[t].equals(maximum)))
			{
				t++;
			}
		
				l = t;
				
				
				if (l == 4)
				{
					n = 0;
					caesarCipher(n);
				}
					
					else
				{
					n = l - 4;
					caesarCipher(-n);
					
				}			
		}
			

	/**
	 * vigenereCipher implements the Vigenere Cipher : it shifts all letter from message by the corresponding shift in the 'key'
	 * @param key
	 */
	public void vigenereCipher (int[] key)
	
     	{
		

	int [] keyArr  = new int [key.length];
	int a;
	String myMsg = message;
	String msg = null;

	
	
	for (int i = 0,m = 0; i< myMsg.length(); i++, m++)
     
       {
		
		message = myMsg.substring(i,i+1);
			
		if (m > (key.length-1)) 
	{
	       m = 0;
	      
	      a = keyArr[m];
	      caesarCipher(a);
	      
	      
	      if (msg == null)
	       {
	    	   msg = message;
	       }
	       else
	       {
	    	   msg = msg + message;
	       }
	      
	      
	    message = msg;
	      
	 }
	
		else {
			
			keyArr[m] = key [m];
	
		   a = keyArr[m];
		
	      caesarCipher(a);
	      
	      if (msg == null) 
	      {
	    	   msg = message;
	      }
	       else 
	       {
	    	   msg = msg + message;
	       }
	       
	      
	          message = msg;
	            
		
		    }	

	   }  
	 
	}
     	
     	
     	
	/**
	 * vigenereDecipher deciphers the message given the 'key' according to the Vigenere Cipher
	 * @param key
	 */
	public void vigenereDecipher (int[] key)
{
		int [] keyArr  = new int [key.length];
		int a;
		String myMsg = message;
		String msg = null;

		
		for (int i = 0,m = 0; i< myMsg.length(); i++, m++)
	     
   {
			
			message = myMsg.substring(i,i+1);
			
			
			
			if (m > (key.length-1)) 
		{
		       m = 0;
		      
		      a = keyArr[m];
		      caesarCipher(-a);
		      
		      
		      if (msg == null)
		      {
		    	   msg = message;
		      }
		       else
		       {
		    	   msg = msg + message;
		       }
		      
		            message = msg;
		
		      
		 }
			
	else
			
		{
				
				keyArr[m] = key [m];
				
				
				
				
			   a = keyArr[m];
			
		      caesarCipher(-a);
		      
		      
		      if (msg == null) 
		      {
		    	   msg = message;
		       }
		       else 
		       {
		    	   msg = msg + message;
		       }
		    message = msg;
		
		}	
		
		
	}
		
}

	/**
	 * transpositionCipher performs the transition cipher on the message by reorganizing the letters and eventually adding characters
	 * @param key
	 */
	public void transpositionCipher (int key)
	
{
		int rowSize = 0;
		
		while(key*rowSize < message.length())
		{
			rowSize++;
		}
		
	String tr [][] = new String [rowSize][key];
	int i = 0;
	int row = 0 ;
    int column = 0;

	String t = null;
	
	for ( ;  i < message.length(); column++, i++)
	  {

	if(key == column)
		
	{
		
		
		column = 0;
		row++;
	
	tr[row][column] = message.substring(i,i+1);
		
	}
			
	else
	{

		tr[row][column] = message.substring(i,i+1);

	}
	
	    }
	
//	System.out.println(column);
	
	for(int j = column; j < key; j++ )
	{
		tr[row][j] = "*";
		
	}	
	
	
	for (int clm = 0; clm<key; clm++)
	{
		
		for(int rw = 0; rw<rowSize; rw++)
		{
			if(t==null) 
			{
				t = tr[rw][clm];
			}
			else
			{
				t = t + tr[rw][clm];
			}
		}
	}

		
	message = t;
	lengthOfMessage = message.length();
	
	
			
						
}

	/**
	 * transpositionDecipher deciphers the message given the 'key'  according to the transition cipher.
	 * @param key
	 */
	public void transpositionDecipher (int key)
		
		
  {
			
			int rowSize = 0;
			
			while(key*rowSize < message.length())
			{
				rowSize++;
			}
			
		String tr [][] = new String [rowSize][key];
		int i = 0;
		int row = 0 ;
	    int column = 0;
		
		String t = null;
	
		for ( ;  i < message.length(); row++, i++)
		{
		

		
		if(row >= rowSize)
			
		     {			
			    row = 0;
			    column++;
		        tr[row][column] = message.substring(i,i+1);		
			
			  }	
		
		else 
		     {
		
			tr[row][column] = message.substring(i,i+1);
			
			
		     }
			
			}
		
		for (int rw = 0; rw< rowSize; rw++) {
			
			for(int clm = 0; clm<key; clm++) {
			
					
				if(t==null) {
					t = tr[rw][clm];
				}
				else {
					t = t + tr[rw][clm];
				}
						}
			}
		
		
		if (t.contains("*"))
		{
		
		message = t.replaceAll("[*]", "");
	
	
		}
		
		else
		{
			message = t;
		
		
		}
		
		 lengthOfMessage = message.length();
		
  }
				
							
}
