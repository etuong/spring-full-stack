package com.booksmart.utility;

import com.booksmart.entity.Book;
import com.booksmart.entity.Role;
import com.booksmart.entity.User;
import com.booksmart.service.BookService;
import com.booksmart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Seeder {
    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    public void seedUsers() {
        User user = User.builder().username("q").password("q").email("noreply@gmail.com").build();
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setId(1L);
        role.setName("ROLE_USER");
        roles.add(role);

        userService.createUser(user, roles);
    }

    public void seedBooks() {
        bookService.save(Book.builder()
                .id(1L)
                .author("Avni Doshi")
                .description("In her youth, Tara was wild. She abandoned her arranged marriage to join an ashram, took a hapless artist for a lover, rebelled against every social expectation of a good Indian woman - all with her young child in tow. Years on, she is an old woman with a fading memory, mixing up her maid's wages and leaving the gas on all night, and her grown-up daughter is faced with the task of caring for a mother who never seemed to care for her.")
                .isbn(9780241441510L)
                .listPrice(9.99)
                .ourPrice(6.99)
                .title("Burnt Sugar")
                .publisher("Penguin Books Ltd")
                .build());

        bookService.save(Book.builder()
                .id(2L)
                .author("Tsitsi Dangarembga")
                .description("Here we meet Tambudzai, living in a run-down youth hostel in downtown Harare and anxious about her prospects after leaving a stagnant job. At every turn in her attempt to make a life for herself, she is faced with a fresh humiliation, until the painful contrast between the future she imagined and her daily reality ultimately drives her to a breaking point.")
                .isbn(9780571355518L)
                .listPrice(10.50)
                .ourPrice(8.99)
                .title("This Mournable Body")
                .publisher("FABER & FABER")
                .build());

        bookService.save(Book.builder()
                .id(3L)
                .author("Douglas Stuart")
                .description("Shuggie is different. Fastidious and fussy, he shares his mother's sense of snobbish propriety. The miners' children pick on him and adults condemn him as no' right. But Shuggie believes that if he tries his hardest, he can be normal like the other boys and help his mother escape this hopeless place.")
                .isbn(9781529019278L)
                .listPrice(12.99)
                .ourPrice(7.99)
                .title("Shuggie Bain")
                .publisher("Pan MacMillan")
                .build());

        bookService.save(Book.builder()
                .id(4L)
                .author("Delia Owens")
                .description("For years, rumors of the 'Marsh Girl' have haunted Barkley Cove, a quiet town on the North Carolina coast. So in late 1969, when handsome Chase Andrews is found dead, the locals immediately suspect Kya Clark, the so-called Marsh Girl. But Kya is not what they say. Sensitive and intelligent, she has survived for years alone in the marsh that she calls home, finding friends in the gulls and lessons in the sand. Then the time comes when she yearns to be touched and loved. When two young men from town become intrigued by her wild beauty, Kya opens herself to a new life - until the unthinkable happens.")
                .isbn(9781472154668L)
                .listPrice(15.99)
                .ourPrice(9.99)
                .title("Where the Crawdads Sing")
                .publisher("Little, Brown Book Group")
                .build());

        bookService.save(Book.builder()
                .id(5L)
                .author("President Barack Obama")
                .description("In the stirring, highly anticipated first volume of his presidential memoirs, Barack Obama tells the story of his improbable odyssey from young man searching for his identity to leader of the free world, describing in strikingly personal detail both his political education and the landmark moments of the first term of his historic presidency-a time of dramatic transformation and turmoil.")
                .isbn(9780241491515L)
                .listPrice(15.99)
                .ourPrice(12.99)
                .title("A Promised Land")
                .publisher("PENGUIN")
                .build());

        bookService.save(Book.builder()
                .id(6L)
                .author("Jordan B. Peterson")
                .description("In 12 Rules for Life, acclaimed public thinker and clinical psychologist Jordan B. Peterson offered an antidote to the chaos in our lives: eternal truths applied to modern anxieties. His insights have helped millions of readers and resonated powerfully around the world.")
                .isbn(9780241407622L)
                .listPrice(9.99)
                .ourPrice(5.99)
                .title("Beyond Order : 12 More Rules for Life")
                .publisher("Penguin Books Ltd")
                .build());

        bookService.save(Book.builder()
                .id(7L)
                .author("Chris Dickason")
                .description("Brain Games for Clever Kids is a fantastic bestselling puzzle book, brimming with memory, word and number workouts for the cleverest of kids!")
                .isbn(9781780552491L)
                .listPrice(7.50)
                .ourPrice(4.25)
                .title("Brain Games For Clever Kids")
                .publisher("Michael O'Mara Books Ltd")
                .build());

        bookService.save(Book.builder()
                .id(8L)
                .author("Ixta Belfrage")
                .description("In this stunning new cookbook Yotam and co-writer Ixta Belfrage break down the three factors that create flavour and offer innovative vegetable dishes that deliver brand-new ingredient combinations to excite and inspire.")
                .isbn(9781785038938L)
                .listPrice(12.69)
                .ourPrice(10.25)
                .title("Ottolenghi FLAVOUR")
                .publisher("Ebury Publishing")
                .build());

        bookService.save(Book.builder()
                .id(9L)
                .author("Gabriel Krauze")
                .description("This life is like being in an ocean. Some people keep swimming towards the bottom. Some people touch the bottom with one foot, or even both, and then push themselves off it to get back up to the top, where you can breathe. Others get to the bottom and decide they want to stay there. I don't want to get to the bottom because I'm already drowning.")
                .isbn(9780008374990L)
                .listPrice(5.99)
                .ourPrice(1.99)
                .title("Who They Was")
                .publisher("HarperCollins Publishers")
                .build());

        bookService.save(Book.builder()
                .id(10L)
                .author("Jojo Moyes")
                .description("Alice Wright doesn't love her new American husband. Nor her domineering father-in-law or the judgmental townsfolk of Baileyville, Kentucky. Stifled and misunderstood, she yearns for escape and finds it in defiant Margery O'Hare and the sisterhood bringing books to the isolated and vulnerable.")
                .isbn(9780718183219L)
                .listPrice(9.99)
                .ourPrice(9.99)
                .title("The Giver of Stars")
                .publisher("asd")
                .build());

        bookService.save(Book.builder()
                .id(11L)
                .author("Maaza Mengiste")
                .description("Hirut and the other women long to do more than care for the wounded and bury the dead. When Emperor Haile Selassie goes into exile and Ethiopia quickly loses hope, it is Hirut who offers a plan to maintain morale. She helps disguise a gentle peasant as the emperor and soon becomes his guard, inspiring other women to take up arms. But how could she have predicted her own personal war, still to come, as a prisoner of one of Italy's most vicious officers?")
                .isbn(9781838851170L)
                .listPrice(14.49)
                .ourPrice(10.49)
                .title("The Shadow King")
                .publisher("Canongate Books Ltd")
                .build());

        bookService.save(Book.builder()
                .id(12L)
                .author("Rose Tremain")
                .description("In the city of Bath, in the year 1865, an extraordinary young woman renowned for her nursing skills is convinced that some other destiny will one day show itself to her. But when she finds herself torn between a dangerous affair with a female lover and the promise of a conventional marriage to an apparently respectable doctor, her desires begin to lead her towards a future she had never imagined.")
                .isbn(9781784743314L)
                .listPrice(8.99)
                .ourPrice(4.99)
                .title("Islands of Mercy")
                .publisher("Vintage Publishing")
                .build());

        bookService.save(Book.builder()
                .id(13L)
                .author("Toshikazu Kawaguchi")
                .description("In Before the Coffee Gets Cold, we meet four visitors, each of whom is hoping to make use of the cafe's time-travelling offer, in order to: confront the man who left them, receive a letter from their husband whose memory has been taken by early onset Alzheimer's, to see their sister one last time, and to meet the daughter they never got the chance to know.")
                .isbn(9781529029581L)
                .listPrice(19.99)
                .ourPrice(14.00)
                .title("Before the Coffee Gets Cold")
                .publisher("Pan MacMillan")
                .build());

        bookService.save(Book.builder()
                .id(14L)
                .author("Pam Zhang")
                .description("Ba dies in the night, Ma is already gone. Lucy and Sam, twelve and eleven, are suddenly alone and on the run. With their father's body on their backs, they roam an unforgiving landscape dotted with giant buffalo bones and tiger paw prints, searching for a place to give him a proper burial. How Much of These Hills is Gold is a sweeping adventure tale, an unforgettable sibling story and a remarkable novel about a family bound and divided by its memories.")
                .isbn(9780349011462L)
                .listPrice(19.99)
                .ourPrice(15.99)
                .title("How Much of These Hills is Gold")
                .publisher("Brown Book Group")
                .build());

        bookService.save(Book.builder()
                .id(15L)
                .author("Madeline Miller")
                .description("In the house of Helios, god of the sun and mightiest of the Titans, a daughter is born. Circe is a strange child - not powerful and terrible, like her father, nor gorgeous and mercenary like her mother. Scorned and rejected, Circe grows up in the shadows, at home in neither the world of gods or mortals. But Circe has a dark power of her own: witchcraft. When her gift threatens the gods, she is banished to the island of Aiaia where she hones her occult craft, casting spells, gathering strange herbs and taming wild beasts. Yet a woman who stands alone will never be left in peace for long - and among her island's guests is an unexpected visitor: the mortal Odysseus, for whom Circe will risk everything.")
                .isbn(9781408890042L)
                .listPrice(9.99)
                .ourPrice(8.99)
                .title("Circe ")
                .publisher("Bloomsbury Publishing PLC")
                .build());

        bookService.save(Book.builder()
                .id(16L)
                .author("Michel Faber")
                .description("Set between England and the wintry land of Liminus, a world enslaved by the monstrous Gamp and populated by fearsome, enchanting creatures, D (Tale of Two Worlds) is a mesmerising tale of friendship and bravery in an uncertain world. Told with simple beauty and warmth, its celebration of moral courage and freethinking is a powerful reminder of our human capacity for strength, hope and justice.")
                .isbn(9780857525109L)
                .listPrice(5.29)
                .ourPrice(2.99)
                .title("D (A Tale of Two Worlds)")
                .publisher("Transworld Publishers Ltd")
                .build());

        bookService.save(Book.builder()
                .id(17L)
                .author("John Rector")
                .description("When a shady hitchhiker offers them cold hard cash for a lift, they can't afford to say no.")
                .isbn(9781471196256L)
                .listPrice(11.99)
                .ourPrice(9.99)
                .title("The Couple in Room 13")
                .publisher("Simon & Schuster Ltd")
                .build());

        bookService.save(Book.builder()
                .id(18L)
                .author("Christine Feehan")
                .description("When Malichai Fortunes attacks a problem, he does it full force - a habit that earns the GhostWalker a painful injury and a forced vacation in San Diego, California. With nothing but physical therapy on the horizon, Malichai is starting to get restless . . . until a striking blue-eyed blonde makes all his senses come alive.")
                .isbn(9780349426686L)
                .listPrice(14.36)
                .ourPrice(11.69)
                .title("Lethal Game")
                .publisher("Penguin Publishing Group")
                .build());

        bookService.save(Book.builder()
                .id(19L)
                .description("One rainy night, a couple welcomes two strangers needing help into their home. It's an act they will regret for the rest of their lives.")
                .publisher("Vintage Publishing")
                .isbn(9781529110548L)
                .listPrice(17.25)
                .ourPrice(14.69)
                .title("The Benefit of Hindsight")
                .author("Susan Hill")
                .build());

        bookService.save(Book.builder()
                .id(20L)
                .author("Abi Elphinstone")
                .description("Magic, adventure, and a whole new world is waiting to be discovered! The perfect series for adventurers aged 9+ and fans of Michelle Harrison, Piers Torday and Jamie Littler. The Unmapped Chronicles will not only leave children entertained, but will also empower them to battle climate change and environmental issues.")
                .isbn(9781471173684L)
                .listPrice(9.99)
                .ourPrice(7.99)
                .title("Jungledrop")
                .publisher("Simon & Schuster Ltd")
                .build());
    }
}
