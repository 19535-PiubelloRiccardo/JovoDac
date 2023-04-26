package it.edu.marconiverona.swt_app_events;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.widgets.Listener;

public class Main {
    
    public static void Operazioni(String operazione) throws NumberFormatException {
        Text myField01 = (Text) Repository.repository_View.get("myField01");
        Text myField02 = (Text) Repository.repository_View.get("myField02");
        Text myField03 = (Text) Repository.repository_View.get("myField03");
        
        int operatore1 = Integer.parseInt(myField01.getText());
        int operatore2 = Integer.parseInt(myField02.getText());
        
        Operazione op_model01 = (Operazione) Repository.repository_Model
                .get("operazioni_model");
        
        float risultato = 0;
        switch (operazione) {
            case "somma":
                risultato = op_model01.somma(operatore1, operatore2);
                break;
            case "differenza":
                risultato = op_model01.differenza(operatore1, operatore2);
                break;
            case "prodotto":
                risultato = op_model01.prodotto(operatore1, operatore2);
                break;
            case "quoziente":
                risultato = op_model01.quoziente(operatore1, operatore2);
                break;
        }
        
        myField03.setText("" + risultato);
    }

    public static void main(String[] args) {

        //------------------------------------
        // istanza finestra principale root
        //------------------------------------
        Display display = new Display();
        Shell root = new Shell(display);
        root.setLayout(new GridLayout(2, true));

        //---- Istanze oggetti grafici + model + control=> CallBack/Listener
        //------------------------------------
        // istanze degli oggetti grafici
        //------------------------------------
        Label myLabe01 = new Label(root, SWT.NORMAL);
        myLabe01.setText("Operando 1");
        Text myField01 = new Text(root, SWT.BORDER);
        
        Label myLabe02 = new Label(root, SWT.NORMAL);
        myLabe02.setText("Operando 2");
        Text myField02 = new Text(root, SWT.BORDER);
        
        Label myLabe03 = new Label(root, SWT.NORMAL);
        myLabe03.setText("Operando");
        ToolBar bar = new ToolBar(root, SWT.BORDER);
        ToolItem myItem1 = new ToolItem(bar, SWT.NORMAL);
        myItem1.setText("+");
        ToolItem myItem2 = new ToolItem(bar, SWT.NORMAL);
        myItem2.setText("-");
        ToolItem myItem3 = new ToolItem(bar, SWT.NORMAL);
        myItem3.setText("x");
        ToolItem myItem4 = new ToolItem(bar, SWT.NORMAL);
        myItem4.setText("/");
        
        Label myLabe04 = new Label(root, SWT.NORMAL);
        myLabe04.setText("Risultato");
        Text myField03 = new Text(root, SWT.BORDER);
        
        

        // Operazioni sulla finestra principale
        root.pack();
        root.open();

        //------------------------------------
        // repository view
        // Nota: viene usato il blocco static on the fly della classe
        // HashMap per far eseguire in un metodo static i put delle key-Object
        //------------------------------------
        Map<String, Object> repository_View = new HashMap<String, Object>() {
            {
                put("root", root);
                put("myLabe01", myLabe01);
                put("myLabe02", myLabe02);
                put("myLabe01", myLabe03);
                put("myLabe04", myLabe04);
                put("myField01", myField01);
                put("myField02", myField02);
                put("myField03", myField03);
                put("bar", bar);
                put("myItem1", myItem1);
                put("myItem2", myItem2);
                put("myItem3", myItem3);
                put("myItem4", myItem4);
            }
        };

        //------------------------------------
        // Istanza di una classe capace di fare una elaborazione
        //------------------------------------
        Operazione operazioni_model = new Operazione();

        //------------------------------------
        // repository model
        //------------------------------------
        Map<String, Object> repository_Model = new HashMap<String, Object>() {
            {
                // costruttore della classe, non dell'istanza
                put("operazioni_model", operazioni_model);
            }
        };

        //------------------------------------
        // istanze oggetti  aventi interface Listener : Listener / CallaBack
        //------------------------------------
        
        Listener myItem1_listener
                = new Listener() {
            @Override
            public void handleEvent(Event e) {
                try {
                    Operazioni("somma");
                } catch (NumberFormatException ex){
                    myField03.setText("Errore");
                }
            } 
        };
        
        Listener myItem2_listener
                = new Listener() {
            @Override
            public void handleEvent(Event e) {
                try {
                    Operazioni("differenza");
                } catch (NumberFormatException ex){
                    myField03.setText("Errore");
                }
            } 
        };
        
        Listener myItem3_listener
                = new Listener() {
            @Override
            public void handleEvent(Event e) {
                try {
                    Operazioni("prodotto");
                } catch (NumberFormatException ex){
                    myField03.setText("Errore");
                }
            } 
        };
        
        Listener myItem4_listener
                = new Listener() {
            @Override
            public void handleEvent(Event e) {
                try {
                    Operazioni("quoziente");
                } catch (NumberFormatException ex){
                    myField03.setText("Errore");
                }
            } 
        };

        //------------------------------------
        // repository listener o callback
        //------------------------------------
        Map<String, Object> repository_Listener = new HashMap<String, Object>() {
            {
                // costruttore della classe, non dell'istanza
                put("myItem1_listener", myItem1_listener);
                put("myItem2_listener", myItem2_listener);
                put("myItem3_listener", myItem3_listener);
                put("myItem4_listener", myItem4_listener);
                
            }
        };

        //------------------------------------
        // inizializza il repository (ovvero l'App)
        //------------------------------------
        Repository.repository_View = repository_View;
        Repository.repository_Model = repository_Model;
        Repository.repository_Listener = repository_Listener;

        //------------------------------------
        // inizializza gli oggetti view che attivano i bottoni
        //------------------------------------
        myItem1.addListener(SWT.Selection,
                (Listener) Repository.repository_Listener.get("myItem1_listener"));
        myItem2.addListener(SWT.Selection,
                (Listener) Repository.repository_Listener.get("myItem2_listener"));
        myItem3.addListener(SWT.Selection,
                (Listener) Repository.repository_Listener.get("myItem3_listener"));
        myItem4.addListener(SWT.Selection,
                (Listener) Repository.repository_Listener.get("myItem4_listener"));
        
        //------------------------------------
        // finche'  la finestra non viene chiusa _
        //        { se ci sono eventi leggi coda degli eventi => esegui
        //          altrimenti in attesa }
        //-------------------------------------          
        while (!root.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();

    }
}