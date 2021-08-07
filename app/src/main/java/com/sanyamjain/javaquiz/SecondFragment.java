package com.sanyamjain.javaquiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.sanyamjain.javaquiz.databinding.FragmentSecondBinding;

public class SecondFragment<answers> extends Fragment {

    private final String[] questions = {"1. int x[] = new int[]{10,20,30};<br><br>Arrays can also be created and initialize as in above statement.", "2. In an instance method or a constructor, 'this' is a reference to the current object.", "3. Garbage Collection is manual process.", "4. The JRE deletes objects when it determines that they are no longer being used. This process is called Garbage Collection.", "5. Constructor overloading is not possible in Java.", "6. Assignment operator is evaluated Left to Right.", "7. All binary operators except for the assignment operators are evaluated from Left to Right", "8. Java programming is not statically-typed, means all variables should not first be declared before they can be used.", "9. In Java SE 7 and later, underscore characters '_' can appear anywhere between digits in a numerical literal", "10. Variable name can begin with a letter, '$', or '_'.", "11. Interfaces can be instantiated.", "12. The modifiers public and static cannot written in either order 'public static' or 'static public'.", "13. A .class file contains bytecodes?", "14. James Gosling is father of Java?", "15. Java technology is both a programming language and a platform."};
    private final boolean[] answers = {true, true, false, true, false, false, true, false, true, true, false, false, true, true, true};
    private int score = 0;
    private int index = 0;

    Button yes;
    Button no;
    TextView question;

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        yes = binding.yes.findViewById(R.id.yes);
        no = binding.no.findViewById(R.id.no);
        question = binding.question.findViewById(R.id.question);
        question.setText(questions[index]);

        binding.yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //If array is not going out of bound
                if(index <= questions.length - 1)
                {
                    if(answers[index])
                    {
                        score++;
                    }
                    index++;
                    if(index <= questions.length - 1)
                    {
                        binding.question.setText(questions[index]);
                    }
                }
                else
                {
                    Toast.makeText(getActivity(), "Your Score is " + score + " out of 15", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index <= questions.length - 1)
                {
                    if(!answers[index])
                    {
                        score++;
                    }
                    index++;
                    if(index <= questions.length - 1)
                    {
                        binding.question.setText(questions[index]);
                    }
                }
                else
                {
                    Toast.makeText(getActivity(), "Your Score is " + score + " out of 15", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}