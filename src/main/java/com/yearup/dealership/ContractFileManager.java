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

                if (contract instanceof LeaseContract lease){
                    writer.write(String.format("%s|%s|%s|%s", lease.getValue(),  lease.getFee(), lease.getTotalPrice(), lease.getMonthlyPayment()));
                }

                else if (contract instanceof SalesContract sale){
                    String finance = sale.isFinanceOption()? "YES":"NO";
                    writer.write(String.format( "%s|%s|%s|%s|%s|%s", sale.getSalesTax(), sale.getRecordingFee(), sale.getProcessingFee(), sale.getTotalPrice(), finance, sale.getMonthlyPayment()));
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

