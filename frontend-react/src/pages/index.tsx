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
  const { 
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
  } = useIndex();

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
          onSelect={(pet) => setPetSelected(pet)}
        />  

        <Dialog 
          open={petSelected !== null}
          fullWidth
          PaperProps={{ sx: { padding: '40px'}}}
          onClose={() => setPetSelected(null)}
        >
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <TextField 
                label={'e-mail'}
                type={'email'}
                fullWidth
                value={email}
                onChange={(e) => setEmail(e.target.value)}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField 
                label={'Quantia mensal'}
                type={'number'}
                fullWidth
                value={price}
                onChange={(e) => setPrice(e.target.value)}
              />
            </Grid>
          </Grid>
          <DialogActions sx={{ marginTop: 4}}>
            <Button
              color={'secondary'}
              onClick={() => setPetSelected(null)}
            >
              Cancelar

            </Button>
            <Button
              variant={'contained'}
              onClick={() => adoption()}
            >
              Confirmar adoção

            </Button>

          </DialogActions>
        </Dialog>

        <Snackbar 
          open={message.length > 0}
          message={message}
          autoHideDuration={3000}
          onClose={() => setMessage('')}
        />
    </div>
  )
}

export default Home
