package btc.btc2;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import org.bitcoinj.core.Address;
import org.bitcoinj.core.DumpedPrivateKey;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.NetworkParameters;

public class btc {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		

				Scanner reader = new Scanner(System.in);  
				System.out.println("Enter Bitcoin Address: ");
				String GivenAddress = reader.nextLine();	
				PrintWriter writer = new PrintWriter(new FileWriter("foundaddress.txt"));
					
				for(;;)	{
				String net = "prod";
				if (args.length >= 1 && (args[0].equals("test") || args[0].equals("prod"))) {       
					net = args[0];
					System.out.println("Using " + net + " network.");
				}
				ECKey key = new ECKey();
				final NetworkParameters netParams;
				if (net.equals("prod")) {
					netParams = NetworkParameters.prodNet();
					} else {
					netParams = NetworkParameters.testNet();
					}
				Address addressFromKey = key.toAddress(netParams);
				String privatekey = key.getPrivateKeyAsHex();
				DumpedPrivateKey privatekey2 = key.getPrivateKeyEncoded(netParams);

					

					if(GivenAddress.equals(addressFromKey)) {
						writer.print(addressFromKey + " " + privatekey2);
						writer.flush();
			System.out.println("Using " + net + " network, Generated address:\n" + addressFromKey + " da private keyz: " + privatekey + " " + privatekey2);
					break;
															} 
					
						}
							reader.close(); writer.flush(); writer.close();
		}

}
