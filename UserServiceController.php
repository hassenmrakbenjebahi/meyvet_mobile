<?php

namespace App\Controller;

use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use App\Entity\User;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Serializer\Encoder\JsonEncoder;
use Symfony\Component\Serializer\Encoder\XmlEncoder;
use Symfony\Component\Serializer\Normalizer\ObjectNormalizer;
use Symfony\Component\Serializer\Serializer;
use App\Repository\UserRepository;
use Doctrine\Persistence\ManagerRegistry;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Serializer\SerializerInterface;
use Symfony\Component\PasswordHasher\Hasher\UserPasswordHasherInterface;
use Symfony\Component\Security\Core\Encoder\UserPasswordEncoderInterface;

/**
 * Summary of UserServiceController
 */
class UserServiceController extends AbstractController
{
   
    #[Route('/user/service/registration_veterinaire/', name: 'app_reg_vet')]

    public function Register_veterinaire(UserRepository $repository ,ManagerRegistry $doctrine, Request $request,UserPasswordHasherInterface $passwordHasher,SerializerInterface $serializer)
    {   
        $email = $request->query->get("email");
        $password = $request->query->get("password");
        $nom = $request->query->get("nom");
        $prenom = $request->query->get("prenom");
        $pays = $request->query->get("pays");
        $gouvernorat = $request->query->get("gouvernorat");
        $ville = $request->query->get("ville");
        $rue = $request->query->get("rue");
        $telephone = $request->query->get("telephone");

        $user = new User();
        $hashedPassword = $passwordHasher->hashPassword(
            $user,
            $password
        );
        
        if(!filter_var($email, FILTER_VALIDATE_EMAIL)){
            return new Response("email invalid.");
        }
        $user->setEmail($email);
        $user->setNom($nom);
        $user->setPrenom($prenom);
        $user->setPassword($hashedPassword);
          // Set their role
          $user->setRoles(['ROLE_VETERINAIRE']);
          $user->setPays($pays);
          $user->setGouvernorat($gouvernorat);
          $user->setVille($ville);
          $user->setRue($rue);
          $user->setTelephone($telephone);

          //set demande acces
          $user->setDemandeAcces(1);
          $user->setBloque(0);
        
       
        try{
            $repository->save($user, true);
            

            return new JsonResponse("account is created", 200);
        }catch(\Exception $ex){
            return new Response("execption".$ex->getMessage());
        }
    }


    
    #[Route('/user/service/registration_Proprietaire/', name: 'app_reg_prop')]

    public function Register_proprietaire(UserRepository $repository ,ManagerRegistry $doctrine, Request $request,UserPasswordHasherInterface $passwordHasher,SerializerInterface $serializer)
    {   
        $email = $request->query->get("email");
        $password = $request->query->get("password");
        $nom = $request->query->get("nom");
        $prenom = $request->query->get("prenom");
        $pays = $request->query->get("pays");
        $gouvernorat = $request->query->get("gouvernorat");
        $ville = $request->query->get("ville");
        $rue = $request->query->get("rue");
        $telephone = $request->query->get("telephone");

        $user = new User();
        $hashedPassword = $passwordHasher->hashPassword(
            $user,
            $password
        );
        
        if(!filter_var($email, FILTER_VALIDATE_EMAIL)){
            return new Response("email invalid.");
        }
        $user->setEmail($email);
        $user->setNom($nom);
        $user->setPrenom($prenom);
        $user->setPassword($hashedPassword);
          // Set their role
          $user->setRoles(['ROLE_PROPRIETAIRE']);
          $user->setPays($pays);
          $user->setGouvernorat($gouvernorat);
          $user->setVille($ville);
          $user->setRue($rue);
          $user->setTelephone($telephone);

          //set demande acces
          $user->setDemandeAcces(0);
          $user->setBloque(0);
        
       
        try{
            $repository->save($user, true);
            

            return new JsonResponse("account is created", 200);
        }catch(\Exception $ex){
            return new Response("execption".$ex->getMessage());
        }
    }


    #[Route('/user/service/registration_magasin/', name: 'app_reg_mag')]

    public function Register_magasin(UserRepository $repository ,ManagerRegistry $doctrine, Request $request,UserPasswordHasherInterface $passwordHasher,SerializerInterface $serializer)
    {   
        $email = $request->query->get("email");
        $password = $request->query->get("password");
        $nom = $request->query->get("nom");
        $pays = $request->query->get("pays");
        $gouvernorat = $request->query->get("gouvernorat");
        $ville = $request->query->get("ville");
        $rue = $request->query->get("rue");
        $telephone = $request->query->get("telephone");

        $user = new User();
        $hashedPassword = $passwordHasher->hashPassword(
            $user,
            $password
        );
        
        if(!filter_var($email, FILTER_VALIDATE_EMAIL)){
            return new Response("email invalid.");
        }
        $user->setEmail($email);
        $user->setNom($nom);
        $user->setPassword($hashedPassword);
          // Set their role
          $user->setRoles(['ROLE_MAGASIN']);
          $user->setPays($pays);
          $user->setGouvernorat($gouvernorat);
          $user->setVille($ville);
          $user->setRue($rue);
          $user->setTelephone($telephone);

          //set demande acces
          $user->setDemandeAcces(1);
          $user->setBloque(0);
        
       
        try{
            $repository->save($user, true);
            

            return new JsonResponse("account is created", 200);
        }catch(\Exception $ex){
            return new Response("execption".$ex->getMessage());
        }
    }


    
    #[Route('/service/login/', name: 'app_login_mobile')]

    public function LoginUser(Request $request, EntityManagerInterface $entityManager, UserPasswordHasherInterface $PasswordHasher): JsonResponse
{
    $username=$request->query->get("email");
    $password=$request->query->get("password");
    $user=$entityManager->getRepository(User::class)->findOneByEmail($username);
    if ($user) {
        if ($PasswordHasher->isPasswordValid($user, $password)) {
            if(in_array('ROLE_VETERINAIRE',$user->getRoles(),true)){
            return $this->json(['id' =>$user->getId(),'nom' =>$user->getNom(),'prenom' =>$user->getPrenom(),'password' =>$user->getPassword(),'email' =>$user->getEmail(),
            'Error'=>"",'pays' =>$user->getPays(),'gouvernorat' =>$user->getGouvernorat(),'ville' =>$user->getVille(),'rue' =>$user->getRue(),'telephone' =>$user->getTelephone(),'role'=>"veterinaire"]);
          }
          elseif(in_array('ROLE_PROPRIETAIRE',$user->getRoles(),true)){
            return $this->json(['id' =>$user->getId(),'nom' =>$user->getNom(),'prenom' =>$user->getPrenom(),'password' =>$user->getPassword(),'email' =>$user->getEmail(),
            'Error'=>"",'pays' =>$user->getPays(),'gouvernorat' =>$user->getGouvernorat(),'ville' =>$user->getVille(),'rue' =>$user->getRue(),'telephone' =>$user->getTelephone(),'role'=>"proprietaire"]);
          }
          elseif(in_array('ROLE_MAGASIN',$user->getRoles(),true)){
            return $this->json(['id' =>$user->getId(),'nom' =>$user->getNom(),'prenom' =>$user->getPrenom(),'password' =>$user->getPassword(),'email' =>$user->getEmail(),
            'Error'=>"",'pays' =>$user->getPays(),'gouvernorat' =>$user->getGouvernorat(),'ville' =>$user->getVille(),'rue' =>$user->getRue(),'telephone' =>$user->getTelephone(),'role'=>"magasin"]);
          }
         }else{
            return $this->json(['User' => '', 'role'=>"admin"]);

         }
    }else{
        return $this->json(['User' => '', 'Error'=>"No account matches this username"]);
    }
    return $this->json(['User' => '', 'Error'=>"par defaut"]);

}
}
