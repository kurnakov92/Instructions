package com.bobrovozka.instructions.frontend;

import com.bobrovozka.instructions.core.entity.Instruction;
import com.bobrovozka.instructions.core.service.InstructionService;
import com.bobrovozka.instructions.frontend.form.AddInstructionForm;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;

public class MainView extends FormLayout {

    private InstructionService service;

    private Grid<Instruction> grid;
    private AddInstructionForm addInstructionForm;

    private HorizontalLayout filtering;
    private TextField nameFilter;
    private Button clearNameFilter;

    private HorizontalLayout toolbar;
    private Button addInstructionBtn;

    public MainView(InstructionService service) {
        this.service = service;
        this.grid = new Grid<>();
        this.filtering = new HorizontalLayout();
        this.nameFilter = new TextField();
        this.clearNameFilter = new Button();
        this.toolbar = new HorizontalLayout();
        this.addInstructionBtn = new Button();

        tuneFields();



    }

    private void tuneFields(){

        filtering.add(nameFilter, clearNameFilter);
        nameFilter.setPlaceholder("Filter by name...");
        nameFilter.setValueChangeMode(ValueChangeMode.EAGER);
        nameFilter.addValueChangeListener(event -> updateList());
        clearNameFilter.setText("Clear");
        clearNameFilter.addClickListener(event -> nameFilter.clear());

        toolbar.add(filtering, addInstructionBtn);
        addInstructionBtn.setText("Add new instruction");
        addInstructionBtn.addClickListener(event -> {
            grid.asSingleSelect().clear();
            addInstructionForm.setInstruction(new Instruction());
        });

        grid.setSizeFull();
        //todo отображение инструкций

    }

    public void updateList() {
        grid.setItems(service.findByName(nameFilter.getValue()));
    }

}
