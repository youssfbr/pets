import { styled } from "@mui/material";

export const ListStyled = styled('ul')`
  width: 100%;
  max-width: 800px;
  margin: 0 auto;
  /* padding: ${({ theme }) => theme.spacing(2)}; */
  padding: 16px;
`;

export const ItemList = styled('li')`
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 40px;
  margin-bottom: 40px;

  ${({ theme }) => theme.breakpoints.down('md')} {
    grid-template-columns: 1fr;
    gap: 10px;
    margin-bottom: 60px;
    padding: 16px;
  }
`;

export const Pic = styled('img')`
  width: 100%;
  border-radius: 4px;
`;

export const Informations = styled('div')`
  display: flex;
  flex-direction: column;
  gap: 16px
`;

export const Name = styled('h2')`
  margin: 0;
`;

export const Description = styled('p')`
  margin: 0;
  word-break: break-word;
`;