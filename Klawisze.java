package application;
import java.lang.*;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import java.util.Random;



import javafx.scene.control.Button;
import java.awt.BorderLayout;
import javafx.scene.control.Label;
import java.awt.TextField;


import javafx.scene.layout.*;


public class Klawisze extends Pierwszaklasa {
	
	
	private int x=1;
	String[] dzialaniawlinii=new String[50];
	int nrdzialania=1;
	int bramkanawartosc=0;
	int licznikwartosci=0;
	void stworzklawiszeiakcje(Pane s)
	{
		Button klawisze[]=new Button[15];
		//odpowiednia numeracja z miejscem na znaki i rowna sie.
		  int nrklawisza=1;
		for(int i=1;i<15;i++)
		{
			if(i%4==0)
			{
				nrklawisza=nrklawisza-1;
			}
			klawisze[i]=new Button(String.valueOf(nrklawisza));
			
		nrklawisza++;
		}
		
		klawisze[0]=new Button("0");
		s.getChildren().add(klawisze[0]);
		klawisze[0].setMinSize(30,50);
		klawisze[0].setTranslateX(70);
		klawisze[0].setTranslateY(196);
	  

		     int ywdol=45;
		     int kolosiebie=0;
		    
		     
//pamietaj ze klawisze maja tablice od 1  nie od 0
		for(int i=1;i<14;i++)
		{
			kolosiebie=kolosiebie+35;
			s.getChildren().add(klawisze[i]);
			klawisze[i].setMinSize(30,50);
			klawisze[i].setTranslateX(35+kolosiebie);
			klawisze[i].setTranslateY(ywdol);
			
			if(i%4==0&&i!=0)
			{
			   ywdol=ywdol+50;
			   kolosiebie=0;
			}
			
			
			nrklawisza++;
		}
		
		
		//ustawienie znakow;
		klawisze[4].setText("+");
		klawisze[8].setText("-");
		klawisze[12].setText("*");
		klawisze[13].setText("=");
		klawisze[13].setTranslateX(120);
		
		TextField liniagornatekst=new TextField();
		
		Label liniagorna=new Label();
		liniagorna.setText(liniagornatekst.getText());
		s.getChildren().add(liniagorna);
	
		
		//
		akcjeklawiszy(klawisze,liniagornatekst,liniagorna);
		
		
    
	}
	
	
	void akcjeklawiszy(Button[] klawisze,TextField liniagornatekst,Label liniagorna)
	{
		
		
		for (x=0;x<15;x++)
		{
			
			
						klawisze[x].setOnAction(e->{String t=(((Button) e.getSource()).getText());
						
						wykonajakcje(t,liniagornatekst,liniagorna);
			
				});
			
				
				
			
				
				
			//}
		
			
		
		}
		
		
		
	}
	
	void wykonajakcje(String wartosc,TextField liniagornatekst,Label liniagorna)
	{
		
		
		if(wartosc=="+"||wartosc=="-"||wartosc=="*")
		{
			if(licznikwartosci==1)
			{
				
				return;}
			else
			{
				
			
			licznikwartosci++;
		
			
			bramkanawartosc=0;
			
			//gdy klikniety zostanie plus zostaje wprowadzona blokada
			//jedyne odblokowanie to inny klawisz
			System.out.println("NR LINCZNIK"+licznikwartosci);
			//pokombinowac z nrdzialania by dzialalo  na 3
			//zajac sie reszta -,*
		}
		}
		//jesli pojawi sie inny znak to bramka sie zamyka
	
		if(bramkanawartosc==1)
		{
			dzialaniawlinii[nrdzialania]=liniagornatekst.getText();
		}
		
		
		System.out.println(wartosc);
		liniagornatekst.setText(liniagornatekst.getText()+wartosc);
		liniagorna.setText(liniagornatekst.getText());
		
		if(wartosc=="+"||wartosc=="-"||wartosc=="*")
		{
			
			//stworzyc cos nowego zawierajacego czesc dzialania zapisze sie poprzednie a nastepnie w tym zapisuje sie to
			//zapisuje sie tez znak jako odzielna czesc
			//po kliknieciu rowna sie leci petla;
			// 2.nr dzialania++;
			
		  dzialaniawlinii[nrdzialania]=liniagornatekst.getText();
		  zerujliniagorna(liniagornatekst,liniagorna);
		  
		  //usun znak
		dzialaniawlinii[nrdzialania]=dzialaniawlinii[nrdzialania].replaceAll("\\+","");
		dzialaniawlinii[nrdzialania]=dzialaniawlinii[nrdzialania].replaceAll("\\-","");
		dzialaniawlinii[nrdzialania]=dzialaniawlinii[nrdzialania].replaceAll("\\*","");
	         System.out.println(dzialaniawlinii[nrdzialania]);
		   
			
		nrdzialania++;
		System.out.println("NR: "+nrdzialania);
		dzialaniawlinii[nrdzialania]=wartosc;
		
	
		nrdzialania++;
		//to sie dodaje przy nastepnej wartosci
		bramkanawartosc=1;
		licznikwartosci=1;
		}
		
		
		
		
		
			
		
		
		 
		
		if(wartosc=="=")
		{int wynik=0;
			for(int i=1;i<=nrdzialania;i++)
			{
				if(dzialaniawlinii[i].contains("+"))
				{
					wynik=wynik+Integer.parseInt(dzialaniawlinii[i-1])+Integer.parseInt(dzialaniawlinii[i+1]);
					break;
					
					
					
				}
				if(dzialaniawlinii[i].contains("-"))
				{
					wynik=wynik+Integer.parseInt(dzialaniawlinii[i-1])-Integer.parseInt(dzialaniawlinii[i+1]);
					break;
					
					
					
				}
				if(dzialaniawlinii[i].contains("*"))
				{
					wynik=wynik+Integer.parseInt(dzialaniawlinii[i-1])*Integer.parseInt(dzialaniawlinii[i+1]);
					break;
					
					
					
				}
				
			}
			nrdzialania=0;
		    
			System.out.println(wynik);
			zerujliniagorna(liniagornatekst,liniagorna);
			liniagorna.setText(String.valueOf(wynik));
			liniagornatekst.setText(String.valueOf(wynik));
			liniagornatekst.setText("");
			
			
			
		}
	
		//wprowadzic funkcje zerowanie
		
		
		
	}
	
	
	
	
	void zerujliniagorna(TextField liniagornatekst,Label liniagorna)
	{
		liniagorna.setText("");
		liniagornatekst.setText("");
		
	}
}
	

//podwojne wcisniecie klawisza -blad
// 
	






