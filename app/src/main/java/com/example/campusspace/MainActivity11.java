package com.example.campusspace;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.campusspace.databinding.ActivityMain11Binding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class MainActivity11 extends AppCompatActivity {
    public ActivityMain11Binding binding;
    int cyear,cmonth,cday,chour,cminutes;
    boolean[] selectmenu;
    ArrayList<Integer> menulist = new ArrayList<>();
    String [] menuArray = {"Main Auditorium", "Mini Hall 1", "Mini Hall 2"};
    int id;
    public DatabaseHelper DB;
    Button fbook;
    Button auditorium;
    TextView selecteddate2, selecteddate3, startselectedtime, endselectedtime;
    public static final String AUDITORIUM= "Store_Auditorium";
    public static final String STARTDATE= "Store_StartDate";

    public static final String ENDDATE= "Store_EndDate";
    public static final String STARTTIME= "Store_Starttime";
    public static final String ENDTIME= "Store_Endtime";
    String hallname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain11Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        selectmenu = new boolean[menuArray.length];
        final DatabaseHelper helper = new DatabaseHelper(this);

        fbook = findViewById(R.id.fbook);
        fbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity11.this, "Successfully Booked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity11.this, MainActivity6.class);
                auditorium=findViewById(R.id.menu);
                selecteddate2=findViewById(R.id.selecteddate2);
                selecteddate3=findViewById(R.id.selecteddate3);
                startselectedtime=findViewById(R.id.startselectedtime);
                endselectedtime=findViewById(R.id.endselectedtime);

                String one = auditorium.getText().toString();
                intent.putExtra(AUDITORIUM,one);

                String two = selecteddate2.getText().toString();
                intent.putExtra(STARTDATE,two);

                String five = selecteddate3.getText().toString();
                intent.putExtra(ENDDATE,five);

                String three = startselectedtime.getText().toString();
                intent.putExtra(STARTTIME,three);

                String four = endselectedtime.getText().toString();
                intent.putExtra(ENDTIME,four);

                startActivity(intent);
            }
        });

        binding.date2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                cyear = calendar.get(Calendar.YEAR);
                cmonth = calendar.get(Calendar.MONTH);
                cday = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity11.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        binding.selecteddate2.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, cyear, cmonth, cday);
                datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis() - 1000);
                datePickerDialog.show();
            }
        });

        binding.date3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                cyear = calendar.get(Calendar.YEAR);
                cmonth = calendar.get(Calendar.MONTH);
                cday = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity11.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        binding.selecteddate3.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, cyear, cmonth, cday);
                datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis() - 1000);
                datePickerDialog.show();
            }
        });


        binding.starttime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                chour = calendar.get(Calendar.HOUR_OF_DAY);
                cminutes = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity11.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        binding.startselectedtime.setText(hourOfDay + ":" + minute);
                    }
                }, chour, cminutes, false);
                timePickerDialog.show();
            }
        });

        binding.endtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                chour = calendar.get(Calendar.HOUR_OF_DAY);
                cminutes = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity11.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        binding.endselectedtime.setText(hourOfDay + ":" + minute);
                    }
                }, chour, cminutes, false);
                timePickerDialog.show();
            }
        });

        binding.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity11.this);
                builder.setTitle("Select Menu");
                builder.setCancelable(false);
                builder.setMultiChoiceItems(menuArray, selectmenu, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            menulist.add(which);
                            Collections.sort(menulist);


                        } else {
                            menulist.remove(which);
                        }
                    }
                });
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int j = 0; j < menulist.size(); j++) {
                            stringBuilder.append(menuArray[menulist.get(j)]);
                            if (j != menulist.size() - 1) {
                                stringBuilder.append(",");
                            }
                        }
                        binding.menu.setText(stringBuilder.toString());
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                });
                builder.setNeutralButton("Clear", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int j = 0; j < selectmenu.length; j++) {
                            selectmenu[j] = false;
                            menulist.clear();
                            binding.menu.setText("");
                        }
                    }
                });
                builder.show();
            }

        });
        if (getIntent().getIntExtra("type", 0) == 1) {
            id = getIntent().getIntExtra("id1", 0);
            if (binding.details2.equals("")) {
                Toast.makeText(this, "Can't be empty", Toast.LENGTH_SHORT).show();
            } else {
                        binding.fbook.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                boolean isinserted = DB.insertOrder(binding.details2.getText().toString(), binding.menu.getText().toString(),
                                        binding.date2.getText().toString(), binding.starttime.getText().toString(), binding.endtime.getText().toString(),
                                        hallname, id);
                                if (isinserted) {
                                    binding.fbook.setEnabled(false);
                                    Toast.makeText(MainActivity11.this, "Hall already exist", Toast.LENGTH_SHORT).show();
                                    ;
                                } else {
                                    Toast.makeText(MainActivity11.this, "Hall Already Booked", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }
            }
        }

