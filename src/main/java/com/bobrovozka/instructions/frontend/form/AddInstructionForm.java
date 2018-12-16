package com.bobrovozka.instructions.frontend.form;

import com.bobrovozka.instructions.core.entity.AccessType;
import com.bobrovozka.instructions.core.entity.Instruction;
import com.bobrovozka.instructions.core.service.InstructionService;
import com.bobrovozka.instructions.frontend.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class AddInstructionForm extends FormLayout {

    private MainView mainView;
    private InstructionService service;

    private Binder<Instruction> binder;
    private TextField name;
    private TextField description;
    private TextArea body;
    private ComboBox<AccessType> accessType;
    private Button save;

    private Instruction instruction;

    public AddInstructionForm(MainView mainView, InstructionService service) {
        this.mainView = mainView;
        this.service = service;
        this.binder = new Binder<>(Instruction.class);
        this.name = new TextField();
        this.description = new TextField();
        this.body = new TextArea();
        this.accessType = new ComboBox<>();
        this.save = new Button();
        HorizontalLayout buttons = new HorizontalLayout(save);
        add(name, description, body, accessType, buttons);
        setInstruction(null);
        tuneFields();

    }

    private void tuneFields() {
        name.setLabel("Name");
        description.setLabel("Description");
        body.setLabel("Instructions:");
        accessType.setItems(AccessType.values());
        save.setText("Save");
        save.addClickListener(event -> this.save());
        binder.bindInstanceFields(this);


    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
        binder.setBean(instruction);
        boolean enabled = instruction != null;
        save.setEnabled(enabled);
        if (enabled) {
            name.focus();
        }
    }

    private void save() {
        service.save(instruction);
        mainView.updateList();
        setInstruction(null);
    }
}
