import { styled } from '@mui/material';

export const TitleStyled = styled('h1')`
  font-size: 20px;
  text-align: center;
  margin-top: 40px; /* ${({ theme }) => theme.spacing(5) }; */
`;

export const SubtitleStyled = styled('h2')`
  font-size: 18px;
  text-align: center;  
  margin-bottom: 40px; /* ${({ theme }) => theme.spacing(5) }; */
  font-weight: normal;
  color: #9EADBA; /* ${({ theme }) => theme.palette.text.secondary }; */
`;