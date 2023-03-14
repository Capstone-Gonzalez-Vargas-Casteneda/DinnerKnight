package com.example.dinnerknight.services;

import com.example.dinnerknight.models.Event;
import com.example.dinnerknight.models.Food;
import com.example.dinnerknight.models.User;
import com.example.dinnerknight.repositories.EventRepository;
import com.example.dinnerknight.repositories.FoodRepository;
import com.example.dinnerknight.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class dataFeeder implements CommandLineRunner {

    @Autowired
    UserRepository userDao;

    @Autowired
    FoodRepository foodDao;

    @Autowired
    EventRepository eventDao;

    @Override
    public void run(String... args) throws Exception {
            feedDataUsers();

            feedDataFood();
    }

    private void feedDataUsers(){
        if(userDao.count() == 0){
            User user1 = new User("jon@email.com", "JonBoy", "John", "Hopper","password");
            User user2 = new User("jane@email.com", "janeslane", "Jane", "Hopper","passwrd");
            User user3 = new User("javier@email.com", "JCasta", "Javier", "Castaneda","pssword");
            User user4 = new User("molly@email.com", "smolly", "Molly", "Livves","passwrd");
            User user5 = new User("tonya@email.com", "tontron", "Tonya", "Hopper" ,"passwurd");
            userDao.save(user1);
            userDao.save(user2);
            userDao.save(user3);
            userDao.save(user4);
            userDao.save(user5);
        }
    }

    private void feedDataFood(){
        if(foodDao.count() == 0){
            Food food1 = new Food("Fettuccine Alfredo", "1 lb Fettuccine Pasta, 1/2 cup Heavy Cream, 1/2 cup Butter, 1/2 cup parmesan, 2 tbsp parsley, Black Pepper", "Cook pasta according to package instructions in a large pot of boiling water and salt.\n" +
                    "Add heavy cream and butter to a large skillet over medium heat until the cream bubbles and the butter melts.\n" +
                    "Whisk in parmesan and add seasoning (salt and black pepper).\n" +
                    "Let the sauce thicken slightly and then add the pasta and toss until coated in sauce.\n" +
                    "Garnish with parsley, and it's ready." );
            Food food2 = new Food("Burek", "1 Packet Filo Pastry, 150g Minced Beef, 150g Onion, 40g Olive oil, Dash Salt, Dash Pepper", "Fry the finely chopped onions and minced meat in oil.\n" +
                    "Add the salt and pepper.\n" +
                    "Grease a round baking tray and put a layer of pastry in it.\n" +
                    "Cover with a thin layer of filling and cover this with another layer of filo pastry which must be well coated in oil.\n" +
                    "Put another layer of filling and cover with pastry.\n" +
                    "When you have five or six layers, cover with filo pastry, bake at 200ºC/392ºF for half an hour and cut in quarters and serve.");
            Food food3 = new Food("Hot and Sour soup", "1/3 cup Mushrooms, 1/3 cup Wood Ear Mushrooms, 2/3 cup Tofu, 1/2 cup pork, 2 1/2 cup chicken Stock, 1/2 tsp Salt, 1/4 tsp Sugar, 1 tsp Sesame Seed oil, 1/4 tsp Pepper, 1/2 tsp hotsauce, 1 1/2 cups Vinegar, 1 tsp Soy Sauce, 1 tbs Cornstarch, 2 tbs Water, 1/4 cup Spring Onions ", "STEP 1 - MAKING THE SOUP In a wok add chicken broth and wait for it to boil.\n" +
                    "Next add salt, sugar, sesame seed oil, white pepper, hot pepper sauce, vinegar and soy sauce and stir for few seconds.\n" +
                    "Add Tofu, mushrooms, black wood ear mushrooms to the wok.\n" +
                    "To thicken the sauce, whisk together 1 Tablespoon of cornstarch and 2 Tablespoon of water in a bowl and slowly add to your soup until it's the right thickness.\n" +
                    "Next add 1 egg slightly beaten with a knife or fork and add it to the soup and stir for 8 seconds Serve the soup in a bowl and add the bbq pork and sliced green onions on top.");
            Food food4 = new Food("Chicken Congee", "8 oz Chicken, pinch Salt, pinch Pepper, 1 tsp Ginger Cordial, 1 tsp ginger, 1 tbs Spring Onions, 1/2 cup Rice, 8 cups Water, 2 oz Coriander", "STEP 1 - MARINATING THE CHICKEN In a bowl, add chicken, salt, white pepper, ginger juice and then mix it together well.\n" +
                    "Set the chicken aside.\n" +
                    "STEP 2 - RINSE THE WHITE RICE Rinse the rice in a metal bowl or pot a couple times and then drain the water.\n" +
                    "STEP 2 - BOILING THE WHITE RICE Next add 8 cups of water and then set the stove on high heat until it is boiling.\n" +
                    "Once rice porridge starts to boil, set the stove on low heat and then stir it once every 8-10 minutes for around 20-25 minutes.\n" +
                    "After 25 minutes, this is optional but you can add a little bit more water to make rice porridge to make it less thick or to your preference.\n" +
                    "Next add the marinated chicken to the rice porridge and leave the stove on low heat for another 10 minutes.\n" +
                    "After an additional 10 minutes add the green onions, sliced ginger, 1 pinch of salt, 1 pinch of white pepper and stir for 10 seconds.\n" +
                    "Serve the rice porridge in a bowl Optional: add Coriander on top of the rice porridge.");
            Food food5 = new Food("Honey Teriyaki Salmon", "1 lb Salmon, 1 tablespoon Olive oil, 2 tablespoons Soy Sauce, 2 tablespoon Sake, 4 tablespoons Sesame Seed", "Mix all the ingredients in the Honey Teriyaki Glaze together.\n" +
                    "Whisk to blend well.\n" +
                    "Combine the salmon and the Glaze together.\n" +
                    "Heat up a skillet on medium-low heat.\n" +
                    "Add the oil, Pan-fry the salmon on both sides until it’s completely cooked inside and the glaze thickens.\n" +
                    "Garnish with sesame and serve immediately.");
            Food food6 = new Food("Baked Salmon with Fennel & tomatoes", "2 medium fennel , 2tbs chopped parsley , Juice of 1 lemon, 175g Cherry tomatoes , 1 tbs olive oil, 350g salmon, Black olives  ", "Heat oven to 180C/fan 160C/gas 4.\n" +
                    "Trim the fronds from the fennel and set aside.\n" +
                    "Cut the fennel bulbs in half, then cut each half into 3 wedges.\n" +
                    "Cook in boiling salted water for 10 mins, then drain well.\n" +
                    "Chop the fennel fronds roughly, then mix with the parsley and lemon zest.\n" +
                    "Spread the drained fennel over a shallow ovenproof dish, then add the tomatoes.\n" +
                    "Drizzle with olive oil, then bake for 10 mins.\n" +
                    "Nestle the salmon among the veg, sprinkle with lemon juice, then bake 15 mins more until the fish is just cooked.\n" +
                    "Scatter over the parsley and serve.");

            Food food7 = new Food("Banana Pancakes", "1 large Banana , 2 medium eggs , pinch baking powder , 1/2 tsp vanilla extract, 1 tsp Oil, 25 g Pecans, 125 g Raspberries", "In a bowl, mash the banana with a fork until it resembles a thick purée.\n" +
                    "Stir in the eggs, baking powder and vanilla.\n" +
                    "Heat a large non-stick frying pan or pancake pan over a medium heat and brush with half the oil.\n" +
                    "Using half the batter, spoon two pancakes into the pan, cook for 1-2 mins each side, then tip onto a plate.\n" +
                    "Repeat the process with the remaining oil and batter.\n" +
                    "Top the pancakes with the pecans and raspberries.");

            foodDao.save(food1);
            foodDao.save(food2);
            foodDao.save(food3);
            foodDao.save(food4);
            foodDao.save(food5);
            foodDao.save(food6);
            foodDao.save(food7);
        }

    }


}
