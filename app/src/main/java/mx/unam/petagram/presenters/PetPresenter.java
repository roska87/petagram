package mx.unam.petagram.presenters;

import android.content.Context;
import java.util.List;

import mx.unam.petagram.fragments.IPetListFragmentView;
import mx.unam.petagram.model.PetConstructor;
import mx.unam.petagram.model.Pet;

public class PetPresenter implements IFragmentPresenter {

    private IPetListFragmentView iFragmentView;
    private Context context;
    private PetConstructor petConstructor;
    private List<Pet> pets;

    public PetPresenter(IPetListFragmentView iFragmentView, Context context){
        this.iFragmentView = iFragmentView;
        this.context = context;
        this.getPets();
    }

    @Override
    public void getPets() {
        petConstructor = new PetConstructor(context);
        pets = petConstructor.getPets();
        this.showPets();
    }

    @Override
    public void showPets() {
        iFragmentView.initializeAdapter(iFragmentView.createAdapter(pets));
        iFragmentView.generateLayout();
    }
}