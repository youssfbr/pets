import type { NextPage } from 'next';
import PetList from '../ui/components/PetList/PetList';
import Title from '../ui/components/Title/Title';

const Home: NextPage = () => {
  return (
    <div> 
      <Title 
        title="" 
        subtitle={
          <span>
            Com um pequeno valor mensal, você <br /> 
            pode <strong>adotar um pet virtualmente.</strong> 
          </span>
        } />   

        <PetList 
          pets={[
            {
              id: 1,
              name: 'Bidu',
              description: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Iusto asperiores animi, accusantium rerum quo debitis officia tempore? Tempora sint sequi dolore nam, molestiae et voluptate, voluptatum modi, recusandae illum temporibus.',
              pic: 'https://image.cachorrogato.com.br/textimages/cachorrinho-ideal'
            },
            {
              id: 2,
              name: 'Shandy',
              description: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Iusto asperiores animi, accusantium rerum quo debitis officia tempore? Tempora sint sequi dolore nam, molestiae et voluptate, voluptatum modi, recusandae illum temporibus.',
              pic: 'https://media.gazetadopovo.com.br/viver-bem/2018/11/dog3-600x459-0e01be20.jpg'
            }
          ]}
        />  
    </div>
  )
}

export default Home
