package example.hans.simpleformandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //set Attribute what do you have in xml file
    private EditText inputName, inputAge, inputEmail, inputPassword, inputConPassword;
    private String name, email, password, confrimPassword;
    private Integer age;
    private Button submitBtn, resetBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // inject with the same id in xml
        inputName = (EditText)findViewById(R.id.inputName);
        inputAge = (EditText)findViewById(R.id.inputAge);
        inputEmail = (EditText)findViewById(R.id.inputEmail);
        inputPassword = (EditText)findViewById(R.id.inputPassword);
        inputConPassword = (EditText)findViewById(R.id.inputConPassword);
        submitBtn = (Button)findViewById(R.id.submitBtn);
        resetBtn = (Button)findViewById(R.id.resetBtn);
        // click listener
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validation for the form
                name=inputName.getText().toString();
                if(!inputAge.getText().toString().equals("")) {
                    age = Integer.parseInt(inputAge.getText().toString());
                }
                email=inputEmail.getText().toString();
                password=inputPassword.getText().toString();
                confrimPassword=inputConPassword.getText().toString();
                if(name.equals("")){
                    Toast.makeText(MainActivity.this, "Name Can't be Empty", Toast.LENGTH_SHORT).show();
                }else if(name.length()<3 || name.length()>20){
                    Toast.makeText(MainActivity.this, "Name field must be between 3 and 20", Toast.LENGTH_SHORT).show();
                }else if(inputAge.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Age Can't be Empty", Toast.LENGTH_SHORT).show();
                }else if(age<5|| age>100){
                    Toast.makeText(MainActivity.this, "Age must be between 5 and 100", Toast.LENGTH_SHORT).show();
                }else if(email.equals("")){
                    Toast.makeText(MainActivity.this, "Email Can't be Empty", Toast.LENGTH_SHORT).show();
                }else if(!email.contains("@") && !email.contains(".")){
                    Toast.makeText(MainActivity.this, "wrong email format", Toast.LENGTH_SHORT).show();
                }else if(password.equals("")){
                    Toast.makeText(MainActivity.this, "password Can't be Empty", Toast.LENGTH_SHORT).show();
                }else if(password.length()<6 || password.length()>30){
                    Toast.makeText(MainActivity.this, "Password must be between 6 and 30", Toast.LENGTH_SHORT).show();
                }else if(!confrimPassword.equals(password)){
                    Toast.makeText(MainActivity.this, "Password not match", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Successfull Login", Toast.LENGTH_SHORT).show();
                }
            }
        });
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //reset all the form
                inputName.setText("");
                inputAge.setText("");
                inputEmail.setText("");
                inputPassword.setText("");
                inputConPassword.setText("");
            }
        });

    }
}
