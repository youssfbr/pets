import { AxiosError } from 'axios';
import { useEffect, useState } from 'react';
import { Pet } from '../../@types/Pet';
import { ApiService } from '../../services/ApiService';

export function useIndex() {
  const [petsList, setPetsList] = useState<Pet[]>([]),
    [petSelected, setPetSelected] = useState<Pet | null>(null),
    [email, setEmail] = useState(''),
    [price, setPrice] = useState(''),
    [message, setMessage] = useState('');

  useEffect(() => {
    ApiService.get('/pets')
    .then((response) => {
      setPetsList(response.data);
    })
  }, [])

  useEffect(() => {
    if (petSelected === null) formClear();    
  }, [petSelected]);

  function adoption() {
    if (petSelected !== null) {
      if (adoptionValidate()) {
        ApiService.post('/adoptions', {
          pet_id: petSelected.id,
          email,
          price
        })
        .then(() => {
          setPetSelected(null);
          setMessage('Parabéns! Pet adotado.');          
        })
        .catch((error: AxiosError) => {
          setMessage(error.response?.data.message);
        })
      } else {
        setMessage('Preencha todos os campos corretamente.')
      }
    }
  }  

  function adoptionValidate() {
    return email.length > 0 && price.length > 0;
  }

  function formClear() {
    setEmail('');
    setPrice('');
  }

  return {
    petsList,
    petSelected, 
    setPetSelected,
    email, 
    setEmail,
    price, 
    setPrice,
    message, 
    setMessage,
    adoption
  };
}