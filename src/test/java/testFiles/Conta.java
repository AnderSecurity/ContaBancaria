package testFiles;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Classe utilizada para realizar os testes de solicitação de saque.
 */
public class Conta {
	
	private double saldo, numero;
	private boolean especial, permitir;
	
	/**
	 * @author Anderson Pereira
	 * Dado um cliente especial com uma quantidade negativa de saldo.
	 * @param int1
	 */	
	@Given("Um cliente especial com saldo atual de {int} reais")
	public void um_cliente_especial_com_saldo_atual_de_reais(Integer int1) {
	    especial = true;
	    saldo = int1;
	}
	
	/**
	 * O cliente especial solicitou um saque de saldo.
	 * @param int1
	 */
	@When("for solicitado um saque no valor de {int} reais")
	public void for_solicitado_um_saque_no_valor_de_reais(Integer int1) {
		
		numero = int1;
		
	    if(especial)
	    {
	    	permitir = true;	
	    }
	}
	
	/**
	 * O saque deve ser realizado, e o saldo mudou diminuiu.
	 * @param int1
	 */
	@Then("deve efetuar o saque e atualizar o saldo da conta para {int} reais")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Integer int1) {
	    if(permitir)
	    {
	    	sacarSaldo();
	    }
	    else
	    {
	    	System.out.println("Você não tem permissão para sacar o dinheiro!");
	    }
	}

	/**
	 * Dado um cliente comum com uma quantidade negativa de saldo.
	 * @param int1
	 */
	@Given("Um cliente comum com saldo atual de {int} reais")
	public void um_cliente_comum_com_saldo_atual_de_reais(Integer int1) {
	    especial = false;
	    saldo = int1;
	}
	
	/**
	 * O cliente comum solicitou um saque de saldo.
	 * @param int1
	 */
	@When("solicitar um saque de {int} reais")
	public void solicitar_um_saque_de_reais(Integer int1) {
		
		numero = int1;
		
	    if(!especial)
	    {
	    	permitir = false;
	    }
	}
	
	/**
	 * O saque não deve ser realizado, e deve retornar a mensagem "Saldo Insuficiente".
	 */
	@Then("não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente")
	public void nao_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente() {
	    if(permitir)
	    {
	    	sacarSaldo();
	    }
	    else
	    {
	    	System.out.println("Você não tem permissão para sacar o dinheiro!");
	    }
	}
	
	public void sacarSaldo() {
		saldo -= numero;
		System.out.println("Saque realizado com sucesso!");
	}
}
