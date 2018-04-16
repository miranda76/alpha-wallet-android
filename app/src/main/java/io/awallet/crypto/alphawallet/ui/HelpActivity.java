package io.awallet.crypto.alphawallet.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import io.awallet.crypto.alphawallet.R;
import io.awallet.crypto.alphawallet.entity.HelpItem;
import io.awallet.crypto.alphawallet.ui.widget.adapter.HelpAdapter;
import io.awallet.crypto.alphawallet.viewmodel.HelpViewModel;
import io.awallet.crypto.alphawallet.viewmodel.HelpViewModelFactory;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class HelpActivity extends BaseActivity {
    @Inject
    HelpViewModelFactory helpViewModelFactory;
    private HelpViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_help);
        toolbar();
        setTitle(getString(R.string.toolbar_header_help));

        RecyclerView list = findViewById(R.id.list_help);
        list.setLayoutManager(new LinearLayoutManager(this));
        HelpAdapter adapter = new HelpAdapter();

        /* Placeholder only */
        int[] questions = {
                R.string.help_question1,
                R.string.help_question2,
                R.string.help_question3,
                //R.string.help_question4,
                R.string.help_question5,
        };

        int[] answers = {
                R.string.what_is_eth,
                R.string.why_alphawallet_eth,
                R.string.how_i_get_money,
                //R.string.help_answer1,
                R.string.how_i_transfer_into_wallet,
        };

        List<HelpItem> helpItems = new ArrayList<>();
        for (int i = 0; i < questions.length; i++) {
            helpItems.add(new HelpItem(getString(questions[i]), getString(answers[i])));
        }
        adapter.setHelpItems(helpItems);

        list.setAdapter(adapter);
    }
}
