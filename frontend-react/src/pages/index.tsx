import type { NextPage } from 'next';
import PetList from '../ui/components/PetList/PetList';
import Title from '../ui/components/Title/Title';
import {
  Button,
  Dialog, 
  DialogActions,
  Grid,
  TextField,
  Snackbar 
} from '@mui/material';
import { useIndex } from '../data/hooks/pages/useIndex';

const Home: NextPage = () => {

  const { petsList } = useIndex();

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
          pets={petsList}
        />  

        <Dialog 
          open={false}
          fullWidth
          PaperProps={{ sx: { padding: '40px'}}}
        >
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <TextField 
                label={'e-mail'}
                type={'email'}
                fullWidth
              />
            </Grid>
            <Grid item xs={12}>
              <TextField 
                label={'Quantia mensal'}
                type={'number'}
                fullWidth
              />
            </Grid>
          </Grid>
          <DialogActions sx={{ marginTop: 4}}>
            <Button
              color={'secondary'}
            >
              Cancelar

            </Button>
            <Button
              variant={'contained'}
            >
              Confirmar adoção

            </Button>

          </DialogActions>
        </Dialog>

        <Snackbar 
          open={false}
          message={'Adoção feita'}
        />
    </div>
  )
}

export default Home
