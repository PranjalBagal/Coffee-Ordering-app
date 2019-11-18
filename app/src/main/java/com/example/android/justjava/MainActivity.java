package com.example.android.justjava;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//import android.support.v7.app.AppCompatActivity;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream=whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate=chocolateCheckBox.isChecked();
        EditText nameField =(EditText) findViewById(R.id.name_field);
        String name=nameField.getText().toString();
        int price = calculatePrice(hasWhippedCream,hasChocolate);
        String priceMessage=createOrderSummary(name,price,hasWhippedCream,hasChocolate);
        displayMessage(priceMessage);
//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:"));
//        intent.putExtra(Intent.EXTRA_SUBJECT,"Order For" + name);
//        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
//        if(intent.resolveActivity(getPackageManager())!=null)
//        {
//            startActivity(intent);
//        }
    }
    public void increment(View view) {
//        if(quantity==100)
//        {
//            Toast.makeText(this,"You cannot have more than 100 coffees",Toast.LENGTH_LONG).show();
//            return;
//        }
        quantity = quantity +1;
        display(quantity);
    }
    public void decrement(View view) {
//        if(quantity==1)
//        {
//            Toast.makeText(this,"You cannot have less than 1 coffee",Toast.LENGTH_LONG).show();
//            return;
//        }
        quantity = quantity -1;
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText( number);
    }
    private int calculatePrice(boolean addWhippedCream,boolean addChocolate)
    {
        int basePrice =5;
        if(addWhippedCream)
        {
            basePrice = basePrice + 1;
        }
        if(addChocolate)
        {
            basePrice = basePrice +2;
        }
        return quantity * basePrice;
    }
    private String createOrderSummary(String name,int price,boolean addWhippedCream,boolean addChocolate)
    {
        String priceMessage="Name : " + name;
        priceMessage=priceMessage+"\nAdd whipped cream ?" + addWhippedCream;
        priceMessage=priceMessage+"\nAdd chocolate ?" + addChocolate;
        priceMessage = priceMessage + "\nquantity = "+ quantity;
        priceMessage = priceMessage + "\nTotal : $" + price;
        priceMessage = priceMessage + "\nThank you!";
        return priceMessage;
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}