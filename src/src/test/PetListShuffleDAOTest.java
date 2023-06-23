package test;

import java.util.List;

import dao.PetListShuffleDAO;
import model.Pet;

public class PetListShuffleDAOTest
{
    public static void main(String[] args)
    {
        PetListShuffleDAO dao = new PetListShuffleDAO();
        List<Pet> petList = dao.select();

        if (petList != null)
        {
            for (Pet pet : petList)
            {
            	 System.out.println ("PICTURE_BOOKS_ID：" + pet.getPicture_books_id());
                 System.out.println("TITLE: " + pet.getTitle());
                 System.out.println("GENRE: " + pet.getGenre());
                 System.out.println("FREE: " + pet.getFree());
                 System.out.println("PICTURE: " + pet.getPicture());
                 System.out.println("FAVORITE:" + pet.getFavorite());
                 System.out.println("--------------------");
            }
        }
    else
        {
            System.out.println("データの取得に失敗しました。");
        }
    }
}
