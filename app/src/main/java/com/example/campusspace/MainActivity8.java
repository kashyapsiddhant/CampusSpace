package com.example.campusspace;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.campusspace.databinding.ActivityMain11Binding;
import com.example.campusspace.databinding.ActivityMain8Binding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class MainActivity8 extends AppCompatActivity {
    public ActivityMain8Binding binding;
    int cyear,cmonth,cday,chour,cminutes;

    boolean[] buildingmenu;
    ArrayList<Integer> buildinglist = new ArrayList<>();
    String [] buildingArray = {"University Building", "Tech Park", "BioTech Block", "MBA Block", "Architecture Block", "HiTech Block"};

    boolean[] floormenu;
    ArrayList<Integer> floorlist = new ArrayList<>();
    String [] floorArray = {"1st Floor", "2nd Floor", "3rd Floor","4th Floor", "5th Floor", "6th Floor", "7nd Floor", "8rd Floor","9th Floor", "10th Floor", "11th Floor"
            , "12nd Floor", "13rd Floor","14th Floor", "15th Floor"};

    boolean[] roommenu;
    ArrayList<Integer> roomlist = new ArrayList<>();
    String [] roomArray = {" Room 1", "Room 2", "Room 3", "Room 4", "Room 5", "Room 6", "Room 7", "Room 8", "Room 9", "Room 10", "Room 11"
            , "Room 12", "Room 13", "Room 14", "Room 15", "Room 16", "Room 17", "Room 18", "Room 19", "Room 20", "Room 21", "Room 22", "Room 23", "Room 24", "Room 25"};
    Button fbook;
    Button building,floor,room;
    TextView selecteddate2, selecteddate3, startselectedtime, endselectedtime;
    public static final String BUILDING= "Store_Building";
    public static final String FLOOR= "Store_Floor";
    public static final String ROOM= "Store_Room";
    public static final String STARTDATE= "Store_Date";

    public static final String ENDDATE= "Store_Date";
    public static final String STARTTIME= "Store_Starttime";
    public static final String ENDTIME= "Store_Endtime";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain8Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        buildingmenu = new boolean[buildingArray.length];
        floormenu = new boolean[floorArray.length];
        roommenu = new boolean[roomArray.length];



        final DatabaseHelper helper = new DatabaseHelper(this);


        fbook = findViewById(R.id.fbook);
        fbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity8.this, "Successfully Booked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity8.this, MainActivity6.class);
                building=findViewById(R.id.building);
                floor=findViewById(R.id.floor);
                room=findViewById(R.id.room);
                selecteddate2=findViewById(R.id.selecteddate2);
                selecteddate3=findViewById(R.id.selecteddate3);
                startselectedtime=findViewById(R.id.startselectedtime);
                endselectedtime=findViewById(R.id.endselectedtime);

                String one = building.getText().toString();
                intent.putExtra(BUILDING,one);

                String six = floor.getText().toString();
                intent.putExtra(FLOOR,six);

                String seven = room.getText().toString();
                intent.putExtra(ROOM,seven);

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

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity8.this, new DatePickerDialog.OnDateSetListener() {
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

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity8.this, new DatePickerDialog.OnDateSetListener() {
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
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity8.this, new TimePickerDialog.OnTimeSetListener() {
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
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity8.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        binding.endselectedtime.setText(hourOfDay + ":" + minute);
                    }
                }, chour, cminutes, false);
                timePickerDialog.show();
            }
        });








        binding.building.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity8.this);
                builder.setTitle("Select Menu");
                builder.setCancelable(false);
                builder.setMultiChoiceItems(buildingArray, buildingmenu, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            buildinglist.add(which);
                            Collections.sort(buildinglist);


                        } else {
                            buildinglist.remove(which);
                        }
                    }
                });
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int j = 0; j < buildinglist.size(); j++) {
                            stringBuilder.append(buildingArray[buildinglist.get(j)]);
                            if (j != buildinglist.size() - 1) {
                                stringBuilder.append(",");
                            }
                        }
                        binding.building.setText(stringBuilder.toString());
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
                        for (int j = 0; j < buildingmenu.length; j++) {
                            buildingmenu[j] = false;
                            buildinglist.clear();
                            binding.building.setText("");
                        }
                    }
                });
                builder.show();
            }

        });










        binding.floor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity8.this);
                builder.setTitle("Select Menu");
                builder.setCancelable(false);
                builder.setMultiChoiceItems(floorArray, floormenu, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            floorlist.add(which);
                            Collections.sort(floorlist);


                        } else {
                            floorlist.remove(which);
                        }
                    }
                });
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int j = 0; j < floorlist.size(); j++) {
                            stringBuilder.append(floorArray[floorlist.get(j)]);
                            if (j != floorlist.size() - 1) {
                                stringBuilder.append(",");
                            }
                        }
                        binding.floor.setText(stringBuilder.toString());
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
                        for (int j = 0; j < floormenu.length; j++) {
                            floormenu[j] = false;
                            floorlist.clear();
                            binding.floor.setText("");
                        }
                    }
                });
                builder.show();
            }

        });











        binding.room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity8.this);
                builder.setTitle("Select Menu");
                builder.setCancelable(false);
                builder.setMultiChoiceItems(roomArray, roommenu, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            roomlist.add(which);
                            Collections.sort(roomlist);


                        } else {
                            roomlist.remove(which);
                        }
                    }
                });
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int j = 0; j < roomlist.size(); j++) {
                            stringBuilder.append(roomArray[roomlist.get(j)]);
                            if (j != roomlist.size() - 1) {
                                stringBuilder.append(",");
                            }
                        }
                        binding.room.setText(stringBuilder.toString());
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
                        for (int j = 0; j < roommenu.length; j++) {
                            roommenu[j] = false;
                            roomlist.clear();
                            binding.room.setText("");
                        }
                    }
                });
                builder.show();
            }

        });
    }
}