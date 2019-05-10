package com.hirw.scala


/*
 * Dato che Scala è anche un linguaggio funzionale, dà molta importanza alle funzioni. 
 * Abbiamo infatti anonymous function, higher order function e altro.
 * Inoltre ci sono diversi modi per scrivere una funzione
 */


class TestFunction {

	def m(x: Int) = x + 1  // Definiamo un metodo chiamato 'm' che prende in input un intero x
			// e ritorna x + 1. L'ultima riga è sempre quella ritornata.


			val f = (x: Int) => x + 1  // Definiamo una funzione chiamata f che prende in input un intero e restituisce l'intero +1.
			                           

			// Le due istruzioni di sopra fanno la stessa cosa. La differenza sostanziale è la seguente:
			// La prima linea inizia con 'def', il che significa che stiamo definendo un metodo;
			// La seconda linea inizia con 'val', che la rende una funzione.

			// Sebbene molti trattino le funzioni e i metodi in Scala in modo interscambiabile, Scala non li tratta nella stessa maniera. 
			// Infatti, per ogni funzione 'val', Scala crea in bin un file .class (es. TestFunction$$anonfun$1.class).
			// Questo perchè Scala tratta tali funzioni come oggetti e quindi crea oggetti .class

			// Dato che le funzioni in Scala sono oggetti, possiamo passare un "oggetto" funzione come argomento o ritornare un "oggetto" funzione da un altra funzione


			val f2 = (x: Int) => x + 1  // definisco un altra funzione


			val simpleStringFun = () => "Hi There!" // definisco una funzione senza argomenti. Da notare come sempre che le robe a sinistra della freccia indicano gli argomenti della
			                                        // funzione, mentre robe a destra della freccia indica il corpo della funzione.
			                                        // Notiamo che non occorre nemmeno la keyword 'return'. Questo perchè Scala lo aggiunge per noi in automatico.
			  


			val evenOrOdd = (x : Int) => {       // Questa non è una funzione "one line", ovvero con corpo avente una sola linea. Pertanto, occorre usare le parentesi graffe {
				if(x % 2 == 0)                     // Ritorniamo o "even" o "odd". Nuovamente, non c'è alcuna keyword "return"
					"even"                             
					else 
						"odd"
			}


			/*
			 * Andiamo a definire qualche metodo. La sintassi dei metodi è molto  a quella Java
			 */

			def sumSalary(eList : List[Employee]) = {  // gli passiamo una Lista di Employee
					var sum = 0
							eList.foreach(e => sum += e.salary)  // per sommare il salario di tutti gli impiegati della lista, usiamo il metodo foreach
							sum                                  // Come si nota, dentro il foreach ci sta: e => sum += e.salary, che ha a destra della freccia un argomento e a sinistra un corpo
			}		                                         // Quindi è una funzione. Tuttavia, qual è il nome della funzione? Non c'è l'ha. Infatti, è una 'anonymous function'.
			
			
			
			// Ricordiamo sempre che una funzione è definita come: argomenti => definizione

			
			// Vogliamo trovare il salario totale degli Employee del dipartimento 10
			def sumSalaryForDept10(eList : List[Employee]) = {
					var sum = 0
							eList.foreach(e => { 
								if(e.dept == 10)
									sum += e.salary
							})
							sum
			}	

			
			// Vogliamo sommare il salario degli impiegati in base al dipartimento che passiamo
		  // Come si nota, come secondo argomento voglio una funzione (ricordiamo che una funzione è un oggetto). La funzione prende un Employee e ritorna un booleano.
			// Si consiglia di guardare prima il Main
			def sumSalarySmart(eList : List[Employee], selection : Employee => Boolean) = {
					var sum = 0
							eList.foreach(e => { 
								if(selection(e))   // Selection è una funzione del tipo x => x.dept>10. Ricordiamo argomento => definizione corpo
									sum += e.salary
							}) 
							sum
			}  
			
			// La funzione appena definita è chiamata Higher Order Function. Una funzione per essere classificata come Higher Order Function deve o prendere in input come argomenti
			// delle funzioni, oppure deve ritornare una funzione (ricordiamo che le funzioni sono trattate come oggetti in Scala).

}

object Main1 {
	def main(args: Array[String]): Unit = {

			val t = new TestFunction()  // istanzio il mio oggetto TestFunction()
					println(t.m(10))
					println(t.f(10))

					println(t.simpleStringFun())
					println(t.evenOrOdd(11))    

					var emily = new Employee("Emily", 1000)
					emily.dept = 10
					var john = new Employee("John", 2000)
					john.dept = 11
					var sam = new Employee("Sam", 10000)
					sam.dept = 10
					var riley = new Employee("Riley", 3000)
					riley.dept = 13
					var jim = new Employee("Jim", 6000)    
					jim.dept = 10

					val elist = List(emily, john, sam, riley, jim)

					println("Total salary: " + t.sumSalary(elist))    

					println("Total salary for dept 10: " + t.sumSalaryForDept10(elist))

					println("Total salary for dept greater than 10: " + t.sumSalarySmart(elist, (x : Employee) => x.dept > 10))

					println("Total salary for dept greater than 10: " + t.sumSalarySmart(elist, x  => x.dept > 10))  
					// Come si nota, quando chiamiamo sumSalaRySmart, gli passiamo una funzione che prende un Employee come argomento e restituisce se il dipartimento è >10.
					// Ovviamente, quando passo una funzione come argomento, definisco quali argomenti deve avere e il corpo. Poi quando la userò passerò a tale funzione i rispettivi parametri.

	}


}