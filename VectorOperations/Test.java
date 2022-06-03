public class Test{
	public static void main(String[] args){
		VectorOperations operations = new VectorOperations();
		Vector A = new Vector(4,2,-3);
		Vector B = new Vector(3,5,2);
		Vector E = new Vector(4,-7);
		Vector D = new Vector(8,2);

		Vector C,R;
		C = operations.vectorsAddition(A, B);
		C.printVector('C');
		C = operations.vectorSubstraction(A, B);
		C.printVector('C');
		C = operations.scarlarMult(3, A);
		C.printVector('C');
		if(operations.equalVectors(E,D)) System.out.println("True");
		else System.out.println("False");
		R = operations.vectorComponents(E, D);
		R.printVector('R');



		/*Vector vectorA = new Vector(2, 3);
		Vector vectorB = new Vector(4, -7);
		Vector vectorC = new Vector(-4, 7);
		Vector vectorD = new Vector(8, 2);
		Vector vectorE = new Vector(4, 2, -3);
		Vector vectorF = new Vector(3, 5, 2);
		Vector vectorG = new Vector(-1, 1, -1);
		Vector vectorR; //vector para guardar de manera temporal el resultado de algunas operaciones.
		
		vectorR = operations.crossProduct(vectorA, vectorB);
		vectorR.printVector('R');

		//1. Modulo de un vector
		System.out.println("Calcular modulo de un vector en R2 Y R3: ");
		vectorA.printVector('A');
		System.out.printf("El modulo del vector A es: %.3f\n",operations.magnitude(vectorA));
		vectorE.printVector('E');
		System.out.printf("El modulo del vector E es: %.3f\n------------\n",operations.magnitude(vectorE));
		
		//2. Sumar n vectores
		System.out.println("Sumar 'n' vectores dados en R2 Y R3: ");
		vectorA.printVector('A');
		vectorB.printVector('B');
		vectorR = operations.vectorsAddition(vectorA,vectorB);
		System.out.printf("La suma de los vectores A y B es: ");
		vectorR.printVector('R');
		vectorE.printVector('E');
		vectorF.printVector('F');
		vectorG.printVector('G');
		vectorR = operations.vectorsAddition(vectorE,vectorF,vectorG);
		System.out.printf("La suma de los vectores E, F y G es: ");
		vectorR.printVector('R');
		System.out.println("------------");
		
		//3. Restar dos vectores
		System.out.println("Restar dos vectores dados en R2: ");
		vectorC.printVector('C');
		vectorD.printVector('D');
		vectorR = operations.vectorSubstraction(vectorC, vectorD);
		System.out.printf("La resta de los vectores C y D es: ");
		vectorR.printVector('R');
		System.out.println("------------");
		
		//4. Multiplicar por un escalar
		System.out.println("Multiplicar un escalar por un vector en R2 y R3: ");
		vectorA.printVector('A');
		System.out.printf("%dA\n",4);
		vectorR = operations.scarlarMult(4, vectorA);
		System.out.printf("El resultado de la multiplicacion es: ");
		vectorR.printVector('R');
		vectorE.printVector('E');
		System.out.printf("%dE\n",3);
		vectorR = operations.scarlarMult(3, vectorE);
		System.out.printf("El resultado de la multiplicacion es: ");
		vectorR.printVector('R');
		System.out.println("------------");
		
		//5. Vectores iguales
		System.out.println("Comprobar si dos vectores en R2 tienen la misma magnitud y pendiente: ");
		vectorB.printVector('B');
		vectorC.printVector('C');
		double mb = operations.magnitude(vectorB);
		double mc = operations.magnitude(vectorC);
		double sb = operations.slope(vectorB);
		double sc = operations.slope(vectorC);
		System.out.printf("Magnitud vector B: %.3f\nPendiente vector B: %.3f\nMaginud vector C: %.3f\nPendiente vector C: %.3f\n",mb,sb,mc,sc);
		if(operations.equalVectors(vectorB,vectorC)) System.out.println("Son vectores iguales\n------------");
		else System.out.println("No son vecotres iguales\n------------");
		

		//8. Encontrar vector V
		System.out.println("Dados los puntos, inicial O(x1,y1) y terminal P(x2,y2), encontrar el vector V tal que V = OP\nPunto inicial: ");
		vectorA.printVector('O');
		System.out.println("Punto terminal: ");
		vectorD.printVector('P');
		vectorR = operations.vectorComponents(vectorA,vectorD);
		System.out.println("El vector V es: ");
		vectorR.printVector('V');
		System.out.println("---------------\n");
		//7. Operacion anidada
		System.out.println("Calcular las siguientes operaciones anidadas: 4(2A+3B)-(C+B) ");
		vectorA.printVector('A');
		vectorB.printVector('B');
		vectorC.printVector('C');
		vectorR = operations.vectorSubstraction(operations.scarlarMult(4,operations.vectorsAddition(operations.scarlarMult(2, vectorA),operations.scarlarMult(3, vectorB))), operations.vectorsAddition(vectorC,vectorB));
		System.out.printf("El resultado de las operaciones anidadas es: ");
		vectorR.printVector('R');*/
	}
}