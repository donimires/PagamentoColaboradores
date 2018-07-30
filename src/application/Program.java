package application;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.print("Entre com o numero de colaboradores:");
		int n = sc.nextInt();
		
		for (int i = 1; i<=n; i++){
			System.out.println("Dados do colaborador " + i);
			System.out.print("Colaborador " + n +  " é terceirizado? (s/n):");
			char c = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Nome: ");
			String name = sc.nextLine();
			System.out.print("Horas: ");
			int hours = sc.nextInt();
			System.out.print("Valor por hora: ");
			double valuePerHour = sc.nextDouble();
			
			if (c == 's'){
				System.out.print("Despesas adicionais: ");
				double additionalcharge = sc.nextDouble();
				list.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalcharge));
				
			} else {
				list.add(new Employee(name, hours, valuePerHour));
			}
			
		}
		
		System.out.println();
		System.out.println("PAYMENTS:");
		for (Employee emp : list){
			System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()) );
		}
		

		sc.close();
	}
	
}
