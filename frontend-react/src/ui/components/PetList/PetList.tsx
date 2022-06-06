import { Button } from "@mui/material";
import { Pet } from "../../../data/@types/Pet";
import { 
  ListStyled,
  ItemList,
  Pic,
  Informations,
  Name,
  Description 
} from "./PetList.style";
import { TextService } from '../../../data/services/TextService';

interface ListProps {
  pets: Pet[];
  onSelect: (pet: Pet) => void;
}

export default function PetList(props: ListProps) {
  const maxWidthText = 200;

  return (
    <ListStyled>
      {props.pets.map(pet => (
        <>
          <ItemList key={pet.id}>
            <Pic src={pet.pic} alt={pet.name} />
            <Informations>
              <Name>{pet.name}</Name>
              <Description>{TextService.textLimit(pet.description, maxWidthText) }</Description>
              <Button
                variant={'contained'}
                fullWidth
                onClick={() => props.onSelect(pet)}
              > 
                Adotar {pet.name}
              </Button>
            </Informations>
          </ItemList>  
        </>
      ))}
    </ListStyled>
  )
}