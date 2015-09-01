package nyc.c4q;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ListActivity extends Activity {

    public ListView list;
    public Button buttonName;
    public Button buttonColor;

    public List<Person> people;
    public boolean firstLast;
    public boolean showColor;
    public ListAdapter listAdapter;
    public PersonComparator comparator;

    public static final Person[] PEOPLE = {
        new Person("Hannah",    "Abbott",          House.Hufflepuff),
        new Person("Katie",     "Bell",            House.Gryffindor),
        new Person("Susan",     "Bones",           House.Hufflepuff),
        new Person("Terry",     "Boot",            House.Ravenclaw),
        new Person("Lavender",  "Brown",           House.Gryffindor),
        new Person("Cho",       "Chang",           House.Ravenclaw),
        new Person("Michael",   "Corner",          House.Ravenclaw),
        new Person("Colin",     "Creevey",         House.Gryffindor),
        new Person("Marietta",  "Edgecombe",       House.Ravenclaw),
        new Person("Justin",    "Finch-Fletchley", House.Hufflepuff),
        new Person("Seamus",    "Finnigan",        House.Gryffindor),
        new Person("Anthony",   "Goldstein",       House.Ravenclaw),
        new Person("Hermione",  "Granger",         House.Gryffindor),
        new Person("Angelina",  "Johnson",         House.Gryffindor),
        new Person("Lee",       "Jordan",          House.Gryffindor),
        new Person("Neville",   "Longbottom",      House.Gryffindor),
        new Person("Luna",      "Lovegood",        House.Ravenclaw),
        new Person("Ernie",     "Macmillan",       House.Hufflepuff),
        new Person("Parvati",   "Patil",           House.Gryffindor),
        new Person("Padma",     "Patil",           House.Ravenclaw),
        new Person("Harry",     "Potter",          House.Gryffindor),
        new Person("Zacharias", "Smith",           House.Hufflepuff),
        new Person("Alicia",    "Spinnet",         House.Gryffindor),
        new Person("Dean",      "Thomas",          House.Gryffindor),
        new Person("Fred",      "Weasley",         House.Gryffindor),
        new Person("George",    "Weasley",         House.Gryffindor),
        new Person("Ginny",     "Weasley",         House.Gryffindor),
        new Person("Ron",       "Weasley",         House.Gryffindor)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        firstLast = false;
        showColor = false;

        people = new ArrayList<Person>(Arrays.asList(PEOPLE));
        comparator = new PersonComparator();

        list = (ListView) findViewById(R.id.list);
        listAdapter = new ListAdapter(this, R.layout.listitem_member, people);
        list.setAdapter(listAdapter);

        buttonName = (Button) findViewById(R.id.button_name);
        buttonName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!firstLast) {
                    firstLast = true;
                    buttonName.setText("First Last");
                    Collections.sort(people, comparator);
                    listAdapter.notifyDataSetChanged();
                } else if (firstLast) {
                    firstLast = false;
                    buttonName.setText("Last, First");
                    Collections.sort(people, comparator);
                    listAdapter.notifyDataSetChanged();
                }
            }
        });

        buttonColor = (Button) findViewById(R.id.button_color);
        buttonColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (showColor) {
                    showColor = false;
                    buttonColor.setText("Show Color");
                    listAdapter.notifyDataSetChanged();
                } else {
                    showColor = true;
                    buttonColor.setText("Hide Color");
                    listAdapter.notifyDataSetChanged();
                }
            }
        });


    }

    public class PersonComparator implements Comparator<Person> {

        public int compare(final Person object1, final Person object2) {
            if (firstLast) {
                return object1.getFirstName().compareTo(object2.getFirstName());
            } else {
                return object1.getLastName().compareTo(object2.getLastName());
            }
        }

    }


    public class ListAdapter extends ArrayAdapter<Person> {

        public ListAdapter(Context context, int textViewResourceId) {
            super(context, textViewResourceId);
        }

        public ListAdapter(Context context, int resource, List<Person> people) {
            super(context, resource, people);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View v = convertView;

            if (v == null) {
                LayoutInflater vi;
                vi = LayoutInflater.from(getContext());
                v = vi.inflate(R.layout.listitem_member, null);
            }

            Person p = getItem(position);

            if (p != null) {
                TextView tt1 = (TextView) v.findViewById(R.id.text_name);
                TextView tt2 = (TextView) v.findViewById(R.id.text_house);
                String firstName = p.firstName;
                String lastName = p.lastName;
                String house = p.getHouse();

                if (tt1 != null) {
                    if (firstLast) {
                        tt1.setText(firstName + " " + lastName);
                    } else {
                        tt1.setText(lastName + ", " + firstName);
                    }
                }

                if (tt2 != null) {
                    tt2.setText(house);

                }

                if (showColor) {
                    int houseColor;

                    if (house.equals("Gryffindor")) {
                        houseColor = R.color.gryffindor_red;
                        v.setBackgroundColor(houseColor);
                    } else if (house.equals("Hufflepuff")) {
                        houseColor = R.color.hufflepuff_yellow;
                        v.setBackgroundColor(houseColor);
                    } else if (house.equals("Ravenclaw")) {
                        houseColor = R.color.ravenclaw_blue;
                        v.setBackgroundColor(houseColor);
                    } else {
                        houseColor = R.color.slytherin_green;
                        v.setBackgroundColor(houseColor);
                    }

                }
            }

            return v;
        }

    }

}
