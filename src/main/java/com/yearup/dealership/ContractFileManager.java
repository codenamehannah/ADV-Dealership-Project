package com.yearup.dealership;
import java.io.*;

public class ContractFileManager {
        public void saveContract(Contract contract){
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("contracts.csv", true))){
                String type = (contract instanceof LeaseContract)? "LEASE":"SALE";

                // Shared attributes
                writer.newLine();
                writer.write(String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|", type, contract.getDate(), contract.getName(), contract.getEmail(),
                        contract.getVehicle().getVin(), contract.getVehicle().getYear(), contract.getVehicle().getMake(), contract.getVehicle().getModel(),
                        contract.getVehicle().getVehicleType(), contract.getVehicle().getColor(), contract.getVehicle().getOdometer(), contract.getVehicle().getPrice()));

                
        }
    }
}
